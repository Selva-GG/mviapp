package com.example.mviapp.presentation.state

import com.example.mviapp.model.Recipe
import com.example.mviapp.presentation.IReducer

data class RecipeState(
    val recipes: List<Recipe>,
    val ingredients: Map<Int, List<String>> = emptyMap() // Added ingredients detail
) : IReducer.State