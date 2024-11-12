package com.example.jetpackcomposedemo.navigation

sealed class NavScreens {
    data object LoginScreen : NavScreens()
    data object HomeScreen : NavScreens()
}