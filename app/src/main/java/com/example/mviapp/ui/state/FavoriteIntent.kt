package com.example.mviapp.ui.state

sealed class FavoriteIntent : MainIntent() {
    object LoadFavorites : FavoriteIntent()
}
