package com.example.mviapp.presentation.screens.settings

import com.example.mviapp.presentation.Base
import com.example.mviapp.presentation.IReducer
import com.example.mviapp.presentation.state.SettingsState
import com.example.mviapp.presentation.intent.SettingsIntent
import com.example.mviapp.data.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsHandler @Inject constructor(
    private val userRepository: UserRepository
) : Base<SettingsState, SettingsIntent>(
    initialState = SettingsState(),
    reducer = SettingsReducer()
) {
    override suspend fun initialDataLoad() {
        super.initialDataLoad()
    }
    override fun handleIntent(intent: SettingsIntent) {
        super.handleIntent(intent) // Call the base implementation first
        when (intent) {
            is SettingsIntent.LoadUsers -> {
                CoroutineScope(Dispatchers.IO).launch {
                    val users = userRepository.getUsers()
                    handleIntent(SettingsIntent.SaveUsers(users))
                }
            }
            else -> null
        }
    }
}

// Reducer class for SettingsState
class SettingsReducer : IReducer<SettingsState, SettingsIntent> {
    override fun reduce(state: SettingsState, intent: SettingsIntent): SettingsState? {
        return when (intent) {
            is SettingsIntent.SaveUsers -> state.copy(users = intent.users)
            else -> state
        }
    }
}
priorrt --- plugin
        Architecture , design system confirm
        components design templates
        navigtaion , api , database , notification
        Firebase notification
        account migration
        responsive design


