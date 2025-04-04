package com.example.mviapp.ui.state

sealed class MainIntent {
    object LoadHome : MainIntent()
    object LoadFavorites : MainIntent()
    object LoadSettings : MainIntent()
}