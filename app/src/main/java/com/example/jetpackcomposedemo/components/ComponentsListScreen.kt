package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackcomposedemo.components.navigation.components

@Composable
fun ComposableListScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 50.dp)
    ) {
        item {
            Text(
                text = "Components",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 25.dp)
            )
        }
        items(components) { component ->
            Button(
                onClick = { navController.navigate(component.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = component.name,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}