package com.example.mviapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mviapp.repository.RecipeRepository
import com.example.mviapp.repository.FavoriteRepository
import com.example.mviapp.repository.UserRepository
import com.example.mviapp.ui.state.FavoriteIntent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.mviapp.ui.state.MainIntent
import com.example.mviapp.ui.state.MainState
import com.example.mviapp.ui.state.HomeState
import com.example.mviapp.ui.state.UserState
import com.example.mviapp.ui.state.FavoriteState
import com.example.mviapp.ui.state.RecipeIntent
import com.example.mviapp.ui.state.UserIntent

class MainViewModel : ViewModel() {
    private val recipeRepository = RecipeRepository()
    private val favoriteRepository = FavoriteRepository()
    private val userRepository = UserRepository()

    private val _mainState = MutableStateFlow<MainState>(MainState())
    val mainState: StateFlow<MainState> get() = _mainState


    fun processIntent(intent: MainIntent) {
        when (intent) {
            is UserIntent.LoadUsers -> loadUserState()
            is RecipeIntent.LoadRecipes -> loadHomeState()
            is FavoriteIntent.LoadFavorites -> loadFavoritesState()
            // Add intents for settings if needed
            MainIntent.LoadFavorites -> TODO()
            MainIntent.LoadHome -> TODO()
            MainIntent.LoadSettings -> TODO()
            RecipeIntent.RefreshData -> TODO()
            is RecipeIntent.SearchRecipes -> TODO()
            is RecipeIntent.SelectRecipe -> TODO()
        }
    }

    private fun loadHomeState() {
        viewModelScope.launch {
            val recipes = recipeRepository.getRecipes()
            val users = userRepository.getUsers()
            _mainState.value = _mainState.value.copy(homeState = HomeState(recipes, users))
        }
    }

    private fun loadFavoritesState() {
        viewModelScope.launch {
            val favorites = favoriteRepository.getFavorites()
            _mainState.value = _mainState.value.copy(favoritesState = FavoriteState(favorites))
        }
    }

    private fun loadUserState() {
        viewModelScope.launch {
            val users = userRepository.getUsers()
            _mainState.value = _mainState.value.copy(userState = UserState(users))
        }
    }


    // Add methods for settings state if needed
}