package com.example.mviapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.onSubscription
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

abstract class Base<State : IReducer.State, Intent : IReducer.Intent>(
    initialState: State, private val reducer: IReducer<State, Intent>
) : ViewModel() {
    private var initJob :Job? = null
    private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state: StateFlow<State> by lazy {
        _state.onSubscription {
            initJob = viewModelScope.launch {
                initialDataLoad()
            }
        }
            .onCompletion {
                initJob?.cancel()
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000), // Stop collecting after 5 seconds of inactivity
                initialValue = initialState
            )
    }
    init {
        viewModelScope.launch {
            _state.subscriptionCount.collect {
                Log.i("CHECKING" , "subscriptionCount $it - ${initialState}")
            }
        }
    }


    open suspend fun initialDataLoad(){}
    open fun handleIntent(intent: Intent) {
        val newState = reducer.reduce(_state.value, intent)
        if (newState != null) {
            _state.value = newState
        }
    }
}

interface IReducer<State : IReducer.State, Intent : IReducer.Intent> {
    interface State
    interface Intent

    fun reduce(state: State, intent: Intent): State?
}
