package com.example.jetpackcomposedemo.components

import android.icu.util.Calendar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerScreen() {
    var selectedTime by remember { mutableStateOf("") }
    var showTimePicker by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(start = 16.dp, top = 16.dp)) {
        Button(
            onClick = { showTimePicker = true }
        ) {
            Text("Select Time")
        }

        if (showTimePicker) {
            DialWithDialogPicker(
                onConfirm = { timePickerState ->
                    val formattedTime = formatTime(timePickerState.hour, timePickerState.minute)
                    selectedTime = formattedTime
                    showTimePicker = false
                },
                onDismiss = { showTimePicker = false }
            )
        }
        Text(stringResource(R.string.selected_time, selectedTime))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialWithDialogPicker(onConfirm: (TimePickerState) -> Unit, onDismiss: () -> Unit) {
    val currentTime = Calendar.getInstance()
    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true
    )

    TimePickerDialog(onConfirm = { onConfirm(timePickerState) }, onDismiss = onDismiss) {
        TimePicker(timePickerState)
    }
}

@Composable
fun TimePickerDialog(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(stringResource(R.string.dismiss))
            }
        },
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text(stringResource(R.string.ok))
            }
        },
        text = { content() }
    )
}

// Method to format selected time
fun formatTime(hour: Int, minute: Int): String {
    val formattedHour = if (hour < 10) "0$hour" else "$hour"
    val formattedMinute = if (minute < 10) "0$minute" else "$minute"
    return "$formattedHour:$formattedMinute"
}