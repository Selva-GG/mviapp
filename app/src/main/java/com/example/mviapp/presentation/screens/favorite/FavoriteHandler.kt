package com.example.mviapp.presentation.screens.favorite

import com.example.mviapp.data.repository.FavoriteRepository
import com.example.mviapp.presentation.Base
import com.example.mviapp.presentation.IReducer
import com.example.mviapp.presentation.state.FavoriteState
import com.example.mviapp.presentation.intent.FavoriteIntent
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
            else -> null
        }
    }
}

// Reducer class for FavoriteState
class FavoriteReducer : IReducer<FavoriteState, FavoriteIntent> {
    override fun reduce(state: FavoriteState, intent: FavoriteIntent): FavoriteState? {
        return when (intent) {
            is FavoriteIntent.SaveFavorite -> state.copy(favorites = intent.favorites)
            else -> state
        }
    }
}
