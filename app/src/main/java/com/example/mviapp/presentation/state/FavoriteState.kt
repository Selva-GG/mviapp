package com.example.mviapp.presentation.state

import com.example.mviapp.presentation.IReducer
import com.example.mviapp.model.Favorite

// This file can be deleted as its functionality is now part of MainState.
data class FavoriteState(
    val favorites: List<Favorite>,
) : IReducer.State