package com.example.mviapp.repository

import javax.inject.Inject

class MainRepository @Inject constructor() {

    // Function to fetch data from a data source
    suspend fun fetchData(): List<String> {
        // Simulate data fetching
        return listOf("Data 1", "Data 2", "Data 3")
    }

    // Function to save data to a data source
    suspend fun saveData(data: String) {
        // Simulate saving data
    }
}