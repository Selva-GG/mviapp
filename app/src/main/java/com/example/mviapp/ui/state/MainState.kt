package com.example.mviapp.ui.state

data class MainState(
    val homeState: HomeState? = null,
    val favoritesState: FavoriteState? = null,
    val settingsState: SettingsState? = null,
    val userState: UserState? = null
)