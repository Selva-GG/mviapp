package com.example.mviapp.presentation.state

import com.example.mviapp.model.Recipe
import com.example.mviapp.model.User
import com.example.mviapp.presentation.IReducer

data class HomeState(
    val recipes: List<Recipe>,
    val users: List<User>
) : IReducer.State
