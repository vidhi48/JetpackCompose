package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemo.helpers.ReusableAssistChip

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun FlowRowColumnDemo() {
    FlowRow(modifier = Modifier.padding(12.dp)) {
        ReusableAssistChip(onClick = { }, label = "Assist Chip", leadingIcon = Icons.Filled.Settings)
        ReusableAssistChip(onClick = { }, label = "Assist Chip", leadingIcon = Icons.Filled.Settings)
        ReusableAssistChip(onClick = { }, label = "Assist Chip", leadingIcon = Icons.Filled.Settings)
        ReusableAssistChip(onClick = { }, label = "Assist Chip", leadingIcon = Icons.Filled.Settings)
    }

    FlowColumn(modifier = Modifier.padding(12.dp)) {
        ReusableAssistChip(onClick = { }, label = "Assist Chip", leadingIcon = Icons.Filled.Settings)
        ReusableAssistChip(onClick = { }, label = "Assist Chip", leadingIcon = Icons.Filled.Settings)
        ReusableAssistChip(onClick = { }, label = "Assist Chip", leadingIcon = Icons.Filled.Settings)
        ReusableAssistChip(onClick = { }, label = "Assist Chip", leadingIcon = Icons.Filled.Settings)
        ReusableAssistChip(onClick = { }, label = "Assist Chip", leadingIcon = Icons.Filled.Settings)
    }
}