package com.example.mviapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mviapp.ui.screens.RecipeDetailScreen
import com.example.mviapp.ui.screens.RecipeListScreen
import com.example.mviapp.ui.screens.FavoritesScreen
import com.example.mviapp.ui.screens.SettingsScreen
import com.example.mviapp.ui.viewmodel.MainViewModel

sealed class Screen(val route: String) {
    object RecipeList : Screen("recipe_list")
    object RecipeDetail : Screen("recipe_detail")
}

@Composable
fun NavGraph(navController: NavHostController, viewModel: MainViewModel, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = Screen.RecipeList.route, modifier = modifier) {
        composable(Screen.RecipeList.route) {
            RecipeListScreen(navController, viewModel)
        }
        composable(Screen.RecipeDetail.route) {
            RecipeDetailScreen(navController, viewModel)
        }
        composable("favorites") {
            FavoritesScreen(navController, viewModel)
        }
        composable("settings") {
            SettingsScreen(navController, viewModel)
        }
    }
}
