package com.example.jetpackcomposedemo.state

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

// It is used when you want to execute non composable code inside Composable function
// For e.g any code that does not update UI for e.g store data into database
// This SideEffect does not provide coroutine scope
@Composable
fun SideEffectScreen() {
    // Define a state variable for the count
    val count = remember { mutableStateOf(0) }

    // Use SideEffect to log the current value of count
    SideEffect {
        // Called on every recomposition
        Log.e("SideEffect","Count is ${count.value}")
    }

    Column {
        Button(onClick = { count.value++ }) {
            Text("SideEffect")
        }

        // With every state update, text is changed and recomposition is triggered
        Text("Counter ${count.value}")
    }
}