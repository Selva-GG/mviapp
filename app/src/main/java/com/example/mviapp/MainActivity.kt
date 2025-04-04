package com.example.mviapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mviapp.presentation.MainViewModel
import com.example.mviapp.presentation.NavGraph
import dagger.hilt.android.AndroidEntryPoint

val LocalMainViewModel = staticCompositionLocalOf<MainViewModel> {
    error("MainViewModel not provided")
}

val LocalNavController = compositionLocalOf<NavHostController> {
    error("NavController not provided")
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel = hiltViewModel()
            RecipeApp(viewModel)
        }
    }
}

@Composable
fun RecipeApp(viewModel: MainViewModel) {
    val navController = rememberNavController()

    CompositionLocalProvider(
        LocalMainViewModel provides viewModel,
        LocalNavController provides navController
    ) {
        Scaffold(
            bottomBar = { BottomNavigationBar() }
        ) { innerPadding ->
            NavGraph(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun BottomNavigationBar() {
    val navController = LocalNavController.current
    val items = listOf(
        BottomNavItem("Recipes", "recipe_list"),
        BottomNavItem("Favorites", "favorites"),
        BottomNavItem("Settings", "settings")
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.secondary,
        contentColor = MaterialTheme.colorScheme.onSecondary,
        tonalElevation = 8.dp
    ) {
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    when (item.route) {
                        "recipe_list" -> Icon(Icons.Default.Home, contentDescription = "Recipes")
                        "favorites" -> Icon(Icons.Default.Favorite, contentDescription = "Favorites")
                        "settings" -> Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                },
                label = { Text(item.label, style = MaterialTheme.typography.labelSmall) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = MaterialTheme.colorScheme.onSecondary
                )
            )
        }
    }
}

data class BottomNavItem(val label: String, val route: String)