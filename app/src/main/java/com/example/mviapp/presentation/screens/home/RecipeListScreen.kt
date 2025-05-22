package com.example.mviapp.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mviapp.presentation.MainViewModel
import androidx.compose.foundation.clickable
import androidx.compose.runtime.LaunchedEffect
import com.example.mviapp.presentation.intent.RecipeIntent
import com.example.mviapp.LocalMainViewModel
import com.example.mviapp.LocalNavController
import androidx.compose.material3.Button
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mviapp.presentation.intent.FavoriteIntent

@Composable
fun RecipeListScreen() {
    val navController = LocalNavController.current
    val viewModel = LocalMainViewModel.current
    val state = viewModel.recipeHandler.state.collectAsState().value
//    val favorites = viewModel.favoriteHandler.state.collectAsState().value.favorites

    LaunchedEffect(Unit) {
        viewModel.processIntent(RecipeIntent.LoadRecipes)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Recipe List")
        state.recipes.forEach { recipe ->
            val isFavorite = false
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                Text(
                    text = recipe.name,
                    modifier = Modifier.weight(1f).clickable {
                        navController.navigate("recipeDetail/${recipe.id}")
                    }
                )
                Button(onClick = {
                    if (isFavorite) {
                        viewModel.processIntent(FavoriteIntent.DeleteFavorite(recipe.id))
                    } else {
                        viewModel.processIntent(FavoriteIntent.AddToFavorites(recipe.id))
                    }
                }) {
                    Text(text = if (isFavorite) "Unfavorite" else "Favorite")
                }
            }
        }
    }
}
