package com.example.jetpackcomposedemo.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposedemo.components.AppBarScreen
import com.example.jetpackcomposedemo.components.ButtonsScreen
import com.example.jetpackcomposedemo.components.CardScreen
import com.example.jetpackcomposedemo.components.CheckBoxAndRadioScreen
import com.example.jetpackcomposedemo.components.ComposableListScreen
import com.example.jetpackcomposedemo.components.ListWithRowColumScreen
import com.example.jetpackcomposedemo.components.NavigationDrawerScreen
import com.example.jetpackcomposedemo.components.RateDisplayScreen
import com.example.jetpackcomposedemo.components.SliderScreen
import com.example.jetpackcomposedemo.components.SnackBarScreen
import com.example.jetpackcomposedemo.components.TextScreen

@Composable
fun ComponentsNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "composable_list") {
        composable("composable_list") { ComposableListScreen(navController) }
        composable("app_bar") { AppBarScreen() }
        composable("buttons") { ButtonsScreen() }
        composable("card") { CardScreen() }
        composable("check_box_and_radio") { CheckBoxAndRadioScreen() }
        composable("list_with_row_colum") { ListWithRowColumScreen() }
        composable("rate_display") { RateDisplayScreen(navController) }
        composable("navigation_drawer") { NavigationDrawerScreen() }
        composable("slider") { SliderScreen() }
        composable("snack_bar") { SnackBarScreen() }
        composable("text") { TextScreen() }
    }
}