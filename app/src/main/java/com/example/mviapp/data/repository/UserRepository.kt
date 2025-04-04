package com.example.mviapp.data.repository

import com.example.mviapp.model.User

class UserRepository {
    private val users = mutableListOf(
        User(id = 1, name = "John Doe", email = "john.doe@example.com"),
        User(id = 2, name = "Jane Smith", email = "jane.smith@example.com")
    )

    fun getUsers(): List<User> {
        return users
    }

    fun getUserById(id: Int): User? {
        return users.find { it.id == id }
    }

    fun saveUser(user: User) {
        users.removeIf { it.id == user.id }
        users.add(user)
    }
}
