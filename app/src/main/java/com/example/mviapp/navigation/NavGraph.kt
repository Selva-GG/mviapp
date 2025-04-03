package com.example.mviapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mviapp.ui.screens.RecipeDetailScreen
import com.example.mviapp.ui.screens.RecipeListScreen

sealed class Screen(val route: String) {
    object RecipeList : Screen("recipe_list")
    object RecipeDetail : Screen("recipe_detail")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.RecipeList.route) {
        composable(Screen.RecipeList.route) {
            RecipeListScreen(navController)
        }
        composable(Screen.RecipeDetail.route) {
            RecipeDetailScreen(navController)
        }
    }
}
