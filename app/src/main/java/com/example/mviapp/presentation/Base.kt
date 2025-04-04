package com.example.mviapp.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class Base<State : IReducer.State, Intent : IReducer.Intent>(
    initialState: State, private val reducer: IReducer<State, Intent>
) {
    private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state: StateFlow<State> get() = _state.asStateFlow()

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
