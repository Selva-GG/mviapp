package com.example.mviapp.presentation.state

import com.example.mviapp.presentation.IReducer
import com.example.mviapp.model.User

data class SettingsState(
    val isDarkModeEnabled: Boolean = false,
    val notificationEnabled: Boolean = true,
    val users: List<User> = emptyList() // Added users field
) : IReducer.State
