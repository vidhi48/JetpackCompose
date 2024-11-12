package com.example.jetpackcomposedemo.components.navigation

data class Component(val name: String, val route: String)

val components = listOf(
    Component("AppBar", "app_bar"),
    Component("Buttons", "buttons"),
    Component("Card", "card"),
    Component("CheckBox And Radio", "check_box_and_radio"),
    Component("ListWithRowColum", "list_with_row_colum"),
    Component("LazyRow And LazyColumn", "rate_display"),
    Component("NavigationDrawer", "navigation_drawer"),
    Component("Slider", "slider"),
    Component("SnackBar", "snack_bar"),
    Component("Text", "text")
)