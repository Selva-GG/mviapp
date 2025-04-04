package com.example.mviapp.repository

import com.example.mviapp.model.Favorite

class FavoriteRepository {
    fun getFavorites(): List<Favorite> {
        return listOf(
            Favorite(id = 1, recipeId = 1),
            Favorite(id = 2, recipeId = 2)
        )
    }
}
