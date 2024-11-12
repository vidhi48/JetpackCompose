package com.example.jetpackcomposedemo.main_navigation

import kotlinx.serialization.Serializable

sealed class Screens {

    @Serializable
    data object MainList: Screens()

    @Serializable
    data object StateScreen : Screens()

    @Serializable
    data object SideEffect : Screens()

    @Serializable
    data object Components : Screens()

    @Serializable
    data object Navigation : Screens()
}