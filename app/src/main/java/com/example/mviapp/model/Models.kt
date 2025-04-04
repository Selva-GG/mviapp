package com.example.mviapp.model

import kotlin.random.Random

data class Recipe(val id: Int, val name: String, val description: String)
data class Favorite(val id: Int = Random.nextInt(), val recipeId: Int, val name: String = "123")
data class User(val id: Int, val name: String, val email: String)
