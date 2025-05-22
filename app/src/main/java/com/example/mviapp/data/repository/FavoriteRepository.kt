package com.example.mviapp.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import com.example.mviapp.model.Favorite
import com.example.mviapp.presentation.state.FavoriteState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

class FavoriteRepository @Inject constructor() {
    private val favoriteRecipeIds = MutableLiveData<List<Favorite>>(listOf())

    fun addFavorite(recipeId: Int) {
        favoriteRecipeIds.value = favoriteRecipeIds.value?.plus(Favorite(recipeId = recipeId))
    }

    fun removeFavorite(recipeId: Int) {
        val favorites = favoriteRecipeIds.value?.filter { it.recipeId != recipeId }
        favoriteRecipeIds.postValue(favorites ?: listOf())
    }

    fun getFavorites(): Flow<List<Favorite>> {
        return favoriteRecipeIds.asFlow()
    }
}
