package com.example.jetpackcomposedemo.main_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposedemo.components.ComposableListScreen
import com.example.jetpackcomposedemo.components.MainDemoListScreen
import com.example.jetpackcomposedemo.navigation.LoginScreen
import com.example.jetpackcomposedemo.state.NotificationScreen
import com.example.jetpackcomposedemo.state.SideEffectHandlerScreen

@Composable
fun MainNavGraph(navHostController: NavHostController) {
   NavHost(
       navController = navHostController,
       startDestination = Screens.MainList
   ) {
       composable<Screens.MainList> {
           MainDemoListScreen(navHostController)
       }

       composable<Screens.StateScreen>() {
           NotificationScreen()
       }

       composable<Screens.SideEffect>() {
           SideEffectHandlerScreen()
       }

       composable<Screens.Components> {
           ComposableListScreen(navHostController)
       }

       composable<Screens.Navigation> {
           LoginScreen(navHostController)
       }
   }
}