package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SliderScreen() {
    var sliderValue by remember { mutableFloatStateOf(0f) }
    var rangeSliderValue by remember { mutableStateOf(0f..100f) }

    Column(
        modifier = Modifier.padding(top = 50.dp, start = 16.dp, end = 16.dp)
    ) {
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = 2,
            valueRange = 0f..50f,
            thumb = {
                Icon(
                    Icons.Filled.Favorite, contentDescription = "Localized description",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            }
        )
        Text(text = sliderValue.toString())

        RangeSlider(
            value = rangeSliderValue,
            onValueChange = { rangeSliderValue = it },
            valueRange = 0f..100f,
            steps = 3
        )
        Text(rangeSliderValue.toString())
    }
}