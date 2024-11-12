package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemo.R

@Composable
fun ButtonsScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { }) {
            Text(stringResource(R.string.filled_button))
        }

        FilledTonalButton(onClick = {}) {
            Text(stringResource(R.string.filled_tonal_button))
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
            Text(stringResource(R.string.outlined_button))
        }

        ElevatedButton(onClick = { }) {
            Text(stringResource(R.string.elevated_button))
        }

        TextButton(onClick = { }) {
            Text(stringResource(R.string.text_button))
        }

        FloatingActionButton(
            onClick = { },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add")
        }

        ExtendedFloatingActionButton(
            onClick = { },
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add")
            Text(stringResource(R.string.add))
        }
    }
}