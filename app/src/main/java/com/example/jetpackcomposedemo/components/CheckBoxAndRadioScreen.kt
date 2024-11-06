package com.example.jetpackcomposedemo.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxAndRadioScreen() {
    Column {
        CheckBoxScreen()
        RadioButtonScreen()
        ChipScreen()
        DatePickersScreen()
    }
}

@Composable
fun CheckBoxScreen() {
    var checked by remember { mutableStateOf(true) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp, top = 100.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Checkbox")
            Checkbox(checked = checked,
                onCheckedChange = { checked = it })
        }

        Text(
            if (checked) "Checkbox is checked" else "Checkbox is unchecked"
        )
    }
}

@Composable
fun RadioButtonScreen() {
    val foodPref = listOf("Veg", "Non Veg.", "Both")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(foodPref[1] ) }

    Column(modifier = Modifier.padding(top = 20.dp)) {
        foodPref.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
        }

        Text(
            text = "Selected option: $selectedOption",
            modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        )
    }
}

@Composable
fun ChipScreen() {
    var selected by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(top = 20.dp, start = 16.dp)) {
        AssistChip(
            onClick = { Log.e("Chip", "Chip Tapped!")},
            label = { Text("Assist Chip") },
            leadingIcon = {
                Icon(Icons.Filled.Settings, contentDescription = "Localized description")
                Modifier.size(AssistChipDefaults.IconSize)
            }
        )

        FilterChip(
            onClick = { selected = !selected },
            label = { Text("Filter Chip") },
            selected = selected,
            leadingIcon = if (selected) {
                {
                    Icon(Icons.Filled.Settings, contentDescription = "Localized description")
                }
            } else {
                null
            }
        )
    }
}