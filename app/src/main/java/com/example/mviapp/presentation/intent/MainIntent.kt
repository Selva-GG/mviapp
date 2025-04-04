package com.example.mviapp.presentation.intent

sealed class MainIntent {
    object LoadHome : MainIntent()
    object LoadFavorites : MainIntent()
    object LoadSettings : MainIntent()
}