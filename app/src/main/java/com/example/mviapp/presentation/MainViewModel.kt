package com.example.mviapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mviapp.presentation.screens.favorite.FavoriteHandler
import com.example.mviapp.presentation.screens.home.RecipeHandler
import com.example.mviapp.presentation.screens.settings.SettingsHandler
import com.example.mviapp.presentation.intent.FavoriteIntent
import com.example.mviapp.presentation.intent.MainIntent
import com.example.mviapp.presentation.intent.RecipeIntent
import com.example.mviapp.presentation.intent.SettingsIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
     val favoriteHandler: FavoriteHandler,
     val recipeHandler: RecipeHandler,
     val settingsHandler: SettingsHandler
) : ViewModel() {

    fun processIntent(intent: MainIntent) {
        viewModelScope.launch {
            when (intent) {
                is SettingsIntent -> settingsHandler.handleIntent(intent) // Route UserIntent to SettingsHandler
                is RecipeIntent -> recipeHandler.handleIntent(intent)
                is FavoriteIntent -> favoriteHandler.handleIntent(intent)
                else -> Unit // No action for unhandled intents
            }
        }
    }
}