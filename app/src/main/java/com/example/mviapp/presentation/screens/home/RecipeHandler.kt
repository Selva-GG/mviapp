package com.example.mviapp.presentation.screens.home

import com.example.mviapp.data.repository.FavoriteRepository
import com.example.mviapp.data.repository.RecipeRepository
import com.example.mviapp.presentation.Base
import com.example.mviapp.presentation.IReducer
import com.example.mviapp.presentation.intent.RecipeIntent
import com.example.mviapp.presentation.state.RecipeState
import javax.inject.Inject

class RecipeHandler @Inject constructor(
    private val recipeRepository: RecipeRepository,
) : Base<RecipeState, RecipeIntent>(
    initialState = RecipeState(listOf()),
    reducer = RecipeReducer()
) {

    override fun handleIntent(intent: RecipeIntent) {
        super.handleIntent(intent) // Call the base implementation first
        when (intent) {
            is RecipeIntent.LoadRecipes -> {
                val recipes = recipeRepository.getRecipes()
                handleIntent(RecipeIntent.SaveRecipes(recipes))
            }
            is RecipeIntent.LoadIngredients -> {
                val ingredients = recipeRepository.getIngredientsByRecipeId(intent.recipeId)
                handleIntent(RecipeIntent.SaveIngredients(intent.recipeId, ingredients))
            }
            else -> null
        }
    }
}

// Reducer class for RecipeState
class RecipeReducer : IReducer<RecipeState, RecipeIntent> {
    override fun reduce(state: RecipeState, intent: RecipeIntent): RecipeState? {
        return when (intent) {
            is RecipeIntent.SaveRecipes -> state.copy(recipes = intent.recipes)
            is RecipeIntent.SaveIngredients -> state.copy(
                ingredients = state.ingredients + (intent.recipeId to intent.ingredients)
            )
            else -> state
        }
    }
}
