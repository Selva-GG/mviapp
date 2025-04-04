package com.example.mviapp.presentation.screens.recipeDetail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mviapp.presentation.MainViewModel
import com.example.mviapp.presentation.state.HomeState
import com.example.mviapp.data.repository.RecipeRepository
import com.example.mviapp.LocalMainViewModel
import com.example.mviapp.presentation.intent.RecipeIntent
import androidx.compose.material3.Button
import androidx.compose.material3.TextButton
import com.example.mviapp.presentation.intent.FavoriteIntent

@Composable
fun RecipeDetailScreen(recipeId: Int) {
    val viewModel = LocalMainViewModel.current
    val state = viewModel.recipeHandler.state.collectAsState().value
    val favorites = viewModel.favoriteHandler.state.collectAsState().value.favorites
    val recipe = state.recipes.find { it.id == recipeId }
    val ingredients = state.ingredients[recipeId] ?: emptyList()
    val isFavorite = favorites.any { it.recipeId == recipeId }

    LaunchedEffect(recipeId) {
        viewModel.processIntent(RecipeIntent.LoadIngredients(recipeId))
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Recipe Detail")
        recipe?.let {
            Text(text = "Name: ${it.name}")
            Text(text = "Description: ${it.description}")
            Text(text = "Ingredients:")
            ingredients.forEach { ingredient ->
                Text(text = "- $ingredient")
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = {
                if (isFavorite) {
                    viewModel.processIntent(FavoriteIntent.DeleteFavorite(recipeId))
                } else {
                    viewModel.processIntent(FavoriteIntent.AddToFavorites(recipeId))
                }
            }) {
                Text(text = if (isFavorite) "Remove from Favorites" else "Add to Favorites")
            }
        } ?: Text(text = "Recipe not found")
    }
}

