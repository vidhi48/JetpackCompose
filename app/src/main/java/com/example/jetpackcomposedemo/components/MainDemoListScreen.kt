package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackcomposedemo.main_navigation.Screens

@Composable
fun MainDemoListScreen(navController: NavController) {
    Column(
        modifier = Modifier.padding(top = 50.dp, start = 16.dp, end = 16.dp)
    ) {

        Text("Jetpack Compose", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 25.dp))

        Button(
            onClick = { navController.navigate(Screens.StateScreen)},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "State")
        }

        Button(
            onClick = { navController.navigate(Screens.SideEffect)},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Side Effect")
        }

        Button(
            onClick = { navController.navigate(Screens.Components)},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Components")
        }

        Button(
            onClick = {navController.navigate(Screens.Navigation)},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Navigation")
        }
    }
}