package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun DropDownScreen() {
    var expandState by remember { mutableStateOf(false) }
    var selectedCity by remember { mutableStateOf("") }
    val icon = if (expandState) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }
    val cities = listOf("Delhi", "Mumbai", "Chennai", "Kolkata", "Hyderabad", "Bengaluru", "Pune")

    Column(
        modifier = Modifier.padding(top = 15.dp)
    ) {
        OutlinedTextField(
            value = selectedCity,
            onValueChange = { selectedCity = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Select City") },
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { expandState = !expandState })
            },
            readOnly = true
        )

        DropdownMenu(
            expanded = expandState,
            onDismissRequest = { expandState = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            cities.forEach { city ->
                DropdownMenuItem(
                    text = { Text(text = city) },
                    onClick = {
                        selectedCity = city
                        expandState = false
                    }
                )
            }
        }
    }
}