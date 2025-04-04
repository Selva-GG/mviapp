package com.example.mviapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mviapp.ui.state.HomeState
import com.example.mviapp.ui.viewmodel.MainViewModel
import com.example.mviapp.ui.state.MainState

@Composable
fun RecipeListScreen(navController: NavController, viewModel: MainViewModel) {
    val state = viewModel.mainState.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Recipe List")
        when (val currentState = state.value.homeState) {
            is HomeState -> {
                currentState.recipes.forEach { recipe ->
                    Text(text = recipe.name)
                }
            }
            else -> Text(text = "No data available")
        }
    }
}
