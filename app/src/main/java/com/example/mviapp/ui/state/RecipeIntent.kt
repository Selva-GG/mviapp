package com.example.mviapp.ui.state

sealed class RecipeIntent : MainIntent() {
    object LoadRecipes : RecipeIntent()
    data class SelectRecipe(val recipeId: Int) : RecipeIntent()
    data class SearchRecipes(val query: String) : RecipeIntent()
    object RefreshData : RecipeIntent()
}
