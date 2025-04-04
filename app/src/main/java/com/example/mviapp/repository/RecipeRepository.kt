package com.example.mviapp.repository

import com.example.mviapp.model.Recipe

class RecipeRepository {
    fun getRecipes(): List<Recipe> {
        return listOf(
            Recipe(id = 1, name = "Pasta", description = "Delicious Italian pasta"),
            Recipe(id = 2, name = "Pizza", description = "Cheesy pepperoni pizza")
        )
    }
}
