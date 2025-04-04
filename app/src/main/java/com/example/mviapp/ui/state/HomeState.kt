package com.example.mviapp.ui.state

import com.example.mviapp.model.Recipe
import com.example.mviapp.model.User

data class HomeState(
    val recipes: List<Recipe>,
    val users: List<User>
)
