package com.example.mviapp.presentation.intent

import com.example.mviapp.presentation.IReducer
import com.example.mviapp.model.Favorite

sealed class FavoriteIntent : MainIntent(), IReducer.Intent {
    object LoadFavorites : FavoriteIntent()
    data class AddToFavorites(val recipeId: Int) : FavoriteIntent()
    data class SaveFavorite(val favorite: List<Favorite>) : FavoriteIntent()
    data class DeleteFavorite(val favoriteId: Int) : FavoriteIntent()
}
