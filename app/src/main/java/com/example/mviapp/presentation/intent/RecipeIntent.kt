package com.example.mviapp.presentation.intent

import com.example.mviapp.presentation.IReducer
import com.example.mviapp.model.Recipe

sealed class RecipeIntent : MainIntent(), IReducer.Intent {
    object LoadRecipes : RecipeIntent()
    data class SaveRecipes(val recipes: List<Recipe>) : RecipeIntent()
    data class SaveIngredients(val recipeId: Int, val ingredients: List<String>) : RecipeIntent()
    data class LoadIngredients(val recipeId: Int) : RecipeIntent()
    data class SelectRecipe(val recipeId: Int) : RecipeIntent()
    data class SearchRecipes(val query: String) : RecipeIntent()
    object RefreshData : RecipeIntent()
}
