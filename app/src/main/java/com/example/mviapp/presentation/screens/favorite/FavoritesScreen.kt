package com.example.mviapp.presentation.screens.favorite

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mviapp.presentation.MainViewModel
import androidx.compose.runtime.getValue
import androidx.compose.foundation.clickable
import androidx.compose.runtime.LaunchedEffect
import com.example.mviapp.presentation.intent.FavoriteIntent
import com.example.mviapp.LocalMainViewModel
import com.example.mviapp.LocalNavController

@Composable
fun FavoritesScreen() {
    val navController = LocalNavController.current
    val viewModel = LocalMainViewModel.current
    val state by viewModel.favoriteHandler.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.processIntent(FavoriteIntent.LoadFavorites)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Favorites")
        state.favorites.forEach { favorite ->
            Text(
                text = favorite.name,
                modifier = Modifier.clickable {
                    navController.navigate("recipeDetail/${favorite.recipeId}")
                }
            )
        }
    }
}