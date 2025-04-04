package com.example.mviapp.data.repository

import com.example.mviapp.model.User

class UserRepository {
    fun getUsers(): List<User> {
        return listOf(
            User(id = 1, name = "John Doe", email = "john.doe@example.com"),
            User(id = 2, name = "Jane Smith", email = "jane.smith@example.com")
        )
    }

    fun getUserById(id: Int): User? {
        return getUsers().find { it.id == id }
    }

    fun saveUser(user: User) {
        // Simulate saving user
    }
}
