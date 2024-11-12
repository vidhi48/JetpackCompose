package com.example.jetpackcomposedemo.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemo.R

@Composable
fun CheckBoxAndRadioScreen() {
    Column {
        CheckBoxScreen()
        HorizontalDivider(thickness = 2.dp, modifier = Modifier.padding(top = 15.dp))
        RadioButtonScreen()
        HorizontalDivider(thickness = 2.dp, modifier = Modifier.padding(top = 15.dp))
        ChipScreen()
        DatePickersScreen()
        DialogScreen()
    }
}

@Composable
fun CheckBoxScreen() {
    var checked by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 100.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(stringResource(R.string.checkbox))
            Checkbox(checked = checked,
                onCheckedChange = { checked = it })
        }

        Text(
            if (checked) stringResource(R.string.checkbox_is_checked) else stringResource(R.string.checkbox_is_unchecked)
        )
    }
}

@Composable
fun RadioButtonScreen() {
    val foodPref = listOf("Veg", "Non Veg.", "Both")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(foodPref[1]) }

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
            ) {
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
            text = stringResource(R.string.selected_option, selectedOption),
            modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        )
    }
}

@Composable
fun ChipScreen() {
    var selected by remember { mutableStateOf(false) }

    Row(modifier = Modifier.padding(top = 20.dp, start = 16.dp)) {
        AssistChip(
            onClick = { Log.e("Chip", "Chip Tapped!") },
            label = { Text(stringResource(R.string.assist_chip)) },
            leadingIcon = {
                Icon(Icons.Filled.Settings, contentDescription = "Localized description")
                Modifier.size(AssistChipDefaults.IconSize)
            }
        )

        VerticalDivider(
            thickness = 2.dp, modifier = Modifier
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp)
        )

        FilterChip(
            onClick = { selected = !selected },
            label = { Text(stringResource(R.string.filter_chip)) },
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