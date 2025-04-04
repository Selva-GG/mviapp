package com.example.mviapp.presentation.screens.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mviapp.presentation.MainViewModel
import com.example.mviapp.presentation.intent.SettingsIntent
import com.example.mviapp.LocalMainViewModel

@Composable
fun SettingsScreen() {
    val viewModel = LocalMainViewModel.current
    val state = viewModel.settingsHandler.state.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.processIntent(SettingsIntent.LoadUsers)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Settings")
        state.users.forEach { user ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Name: ${user.name}")
                    Text(text = "Email: ${user.email}")
                }
            }
        }
    }
}