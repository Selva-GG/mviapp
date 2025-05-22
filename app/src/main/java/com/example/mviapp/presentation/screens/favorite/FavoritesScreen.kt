package com.example.mviapp.presentation.screens.favorite

import android.util.Log
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
import androidx.compose.material3.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest

@Composable
fun FavoritesScreen() {
    val navController = LocalNavController.current
    val viewModel = LocalMainViewModel.current
    val state by viewModel.favoriteHandler.state.collectAsStateWithLifecycle() // Lifecycle-aware collection

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Favorites")
        state.favorites.forEach { favorite ->
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                Text(
                    text = favorite.name,
                    modifier = Modifier.weight(1f).clickable {
                        navController.navigate("recipeDetail/${favorite.recipeId}")
                    }
                )
                Button(onClick = {
                    viewModel.processIntent(FavoriteIntent.DeleteFavorite(favorite.recipeId))
                }) {
                    Text(text = "Remove")
                }
            }
        }
    }
}


@Preview
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreen()
}