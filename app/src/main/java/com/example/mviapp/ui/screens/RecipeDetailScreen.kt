package com.example.mviapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mviapp.ui.viewmodel.MainViewModel
import com.example.mviapp.ui.state.MainState
import com.example.mviapp.ui.state.HomeState

@Composable
fun RecipeDetailScreen(navController: NavController, viewModel: MainViewModel) {
    val state = viewModel.mainState.collectAsState().value.homeState

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Recipe Detail")

            if (state is HomeState) {
                Text(text = "Detail: ${state.recipes.firstOrNull()?.name ?: "No data"}")
            } else {
                Text(text = "No data available")
            }
        }
    }

