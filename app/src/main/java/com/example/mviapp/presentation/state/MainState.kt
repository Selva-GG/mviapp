package com.example.mviapp.presentation.state

data class MainState(
    val recipeState: RecipeState? = null,
    val favoritesState: FavoriteState? = null,
    val settingsState: SettingsState? = null,
)