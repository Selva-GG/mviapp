package com.example.mviapp.model

data class Recipe(val id: Int, val name: String, val description: String)
data class Favorite(val id: Int, val recipeId: Int , val name: String = "123")
data class User(val id: Int, val name: String, val email: String)
