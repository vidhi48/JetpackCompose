package com.example.jetpackcomposedemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposedemo.components.RateDisplayScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = NavScreens.LoginScreen) {
        composable<NavScreens.LoginScreen> {
            LoginScreen(navController)
        }
        composable<NavScreens.HomeScreen> {
            RateDisplayScreen(navController)
        }
    }
}