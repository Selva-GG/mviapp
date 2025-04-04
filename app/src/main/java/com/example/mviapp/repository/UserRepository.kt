package com.example.mviapp.repository

import com.example.mviapp.model.User

class UserRepository {
    fun getUsers(): List<User> {
        return listOf(
            User(id = 1, name = "John Doe", email = "john.doe@example.com"),
            User(id = 2, name = "Jane Smith", email = "jane.smith@example.com")
        )
    }
}
