package com.example.mviapp.presentation.intent

import com.example.mviapp.presentation.IReducer
import com.example.mviapp.model.User

sealed class SettingsIntent : MainIntent() , IReducer.Intent {
    data object LoadUsers : SettingsIntent()
    data class SaveUsers(val users: List<User> = emptyList()) : SettingsIntent()
    data class DeleteUser(val userId: Int) : SettingsIntent()
}
