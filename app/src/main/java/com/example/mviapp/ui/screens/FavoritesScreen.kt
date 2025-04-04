package com.example.mviapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mviapp.ui.viewmodel.MainViewModel

@Composable
fun FavoritesScreen(navController: NavController, viewModel: MainViewModel) {
    val state = viewModel.mainState.collectAsState().value.favoritesState

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Favorites")
        state?.favorites?.forEach { favorite ->
            Text(text = favorite.name)
        }
    }
}