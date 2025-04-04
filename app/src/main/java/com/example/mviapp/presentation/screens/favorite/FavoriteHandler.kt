package com.example.mviapp.presentation.screens.favorite

import android.util.Log
import com.example.mviapp.data.repository.FavoriteRepository
import com.example.mviapp.presentation.Base
import com.example.mviapp.presentation.IReducer
import com.example.mviapp.presentation.state.FavoriteState
import com.example.mviapp.presentation.intent.FavoriteIntent
import com.example.mviapp.presentation.intent.RecipeIntent
import javax.inject.Inject

class FavoriteHandler @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) : Base<FavoriteState, FavoriteIntent>(
    initialState = FavoriteState(favorites = emptyList()),
    reducer = FavoriteReducer()
) {

    override fun handleIntent(intent: FavoriteIntent) {
        super.handleIntent(intent) // Call the base implementation first
        when (intent) {
            is FavoriteIntent.LoadFavorites -> {
                val favorites = favoriteRepository.getFavorites()
                handleIntent(FavoriteIntent.SaveFavorite(favorites))
            }
            is FavoriteIntent.AddToFavorites -> {
                favoriteRepository.addFavorite(intent.recipeId)
                handleIntent(FavoriteIntent.LoadFavorites)
            }
            is FavoriteIntent.DeleteFavorite -> {
                favoriteRepository.removeFavorite(intent.favoriteId)
                handleIntent(FavoriteIntent.LoadFavorites)
            }
            else -> null
        }
    }
}

// Reducer class for FavoriteState
class FavoriteReducer : IReducer<FavoriteState, FavoriteIntent> {
    override fun reduce(state: FavoriteState, intent: FavoriteIntent): FavoriteState? {
        return when (intent) {
            is FavoriteIntent.SaveFavorite -> state.copy(favorites = intent.favorite)
            else -> state
        }
    }
}
