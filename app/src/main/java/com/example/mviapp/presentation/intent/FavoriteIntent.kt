package com.example.mviapp.presentation.intent

import com.example.mviapp.presentation.IReducer
import com.example.mviapp.model.Favorite

sealed class FavoriteIntent : MainIntent(), IReducer.Intent {
    object LoadFavorites : FavoriteIntent()
    data class SaveFavorite(val favorites: List<Favorite>) : FavoriteIntent()
}
