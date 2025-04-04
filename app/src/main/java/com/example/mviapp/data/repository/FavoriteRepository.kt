package com.example.mviapp.data.repository

import android.util.Log
import com.example.mviapp.model.Favorite
import com.example.mviapp.presentation.state.FavoriteState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

class FavoriteRepository @Inject constructor() {
    private val favoriteRecipeIds = MutableStateFlow<List<Favorite>>(listOf())

    fun addFavorite(recipeId: Int) {
        Log.i("CHECKING" , recipeId.toString())
        favoriteRecipeIds.value = favoriteRecipeIds.value.plus(Favorite(recipeId = recipeId))
    }

    fun removeFavorite(recipeId: Int) {
        val favorites = favoriteRecipeIds.value.filter { it.recipeId != recipeId }
        favoriteRecipeIds.value = favorites
    }

    fun getFavorites(): List<Favorite> {
        return favoriteRecipeIds.value
    }
}
