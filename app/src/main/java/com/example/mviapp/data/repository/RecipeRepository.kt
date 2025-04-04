package com.example.mviapp.data.repository

import com.example.mviapp.model.Recipe
import javax.inject.Inject

class RecipeRepository @Inject constructor() {
    fun getRecipes(): List<Recipe> {
        return listOf(
            Recipe(id = 1, name = "Pasta", description = "Delicious Italian pasta"),
            Recipe(id = 2, name = "Pizza", description = "Cheesy pepperoni pizza")
        )
    }

    fun getRecipeById(id: Int): Recipe? {
        return getRecipes().find { it.id == id }
    }

    fun saveRecipe(recipe: Recipe) {
        // Simulate saving recipe
    }

    fun getIngredientsByRecipeId(id: Int): List<String> {
        return when (id) {
            1 -> listOf("Pasta", "Tomato Sauce", "Cheese")
            2 -> listOf("Pizza Dough", "Tomato Sauce", "Cheese", "Pepperoni")
            else -> emptyList()
        }
    }
}
