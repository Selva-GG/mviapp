package com.example.mviapp.ui.state

sealed class UserIntent : MainIntent() {
    object LoadUsers : UserIntent()
}
