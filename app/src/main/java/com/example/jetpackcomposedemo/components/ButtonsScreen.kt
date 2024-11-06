package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonsScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {  }) {
            Text("Filled button")
        }

        FilledTonalButton(onClick = {}) {
            Text("Filled Tonal Button")
        }

        OutlinedButton(
            onClick = {},
            colors = ButtonColors(
                contentColor = Color.White, containerColor = Color.Blue,
                disabledContainerColor = Color.Blue,
                disabledContentColor = Color.White
            ),
            border = BorderStroke(width = 2.dp, color = Color.Cyan)
        ) {
            Text("Outlined Button")
        }

        ElevatedButton(onClick = { }) {
            Text("Elevated Button")
        }

        TextButton(onClick = { }) {
            Text("Text Button")
        }
    }
}