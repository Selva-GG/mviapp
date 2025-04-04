package com.example.mviapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mviapp.ui.state.MainIntent
import com.example.mviapp.ui.viewmodel.MainViewModel
import com.example.mviapp.ui.state.RecipeIntent

@Composable
fun SettingsScreen(navController: NavController, viewModel: MainViewModel) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Settings Screen")
        Button(onClick = { viewModel.processIntent(MainIntent.LoadSettings) }) {
            Text(text = "Refresh Data")
        }
    }
}