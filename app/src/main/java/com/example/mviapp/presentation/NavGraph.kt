package com.example.mviapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mviapp.presentation.screens.home.RecipeListScreen
import com.example.mviapp.presentation.screens.favorite.FavoritesScreen
import com.example.mviapp.presentation.screens.settings.SettingsScreen
import com.example.mviapp.LocalMainViewModel
import com.example.mviapp.LocalNavController
import com.example.mviapp.presentation.screens.recipeDetail.RecipeDetailScreen

sealed class Screen(val route: String) {
    object RecipeList : Screen("recipe_list")
    object RecipeDetail : Screen("recipe_detail")
}

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = LocalNavController.current

    NavHost(navController = navController, startDestination = Screen.RecipeList.route, modifier = modifier) {
        composable(Screen.RecipeList.route) {
            RecipeListScreen()
        }
        composable("favorites") {
            FavoritesScreen()
        }
        composable("settings") {
            SettingsScreen()
        }

        composable("recipeDetail/{recipeId}") { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getString("recipeId")?.toIntOrNull()
            if (recipeId != null) {
                RecipeDetailScreen(recipeId)
            }
        }
    }
}
