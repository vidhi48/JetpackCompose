package com.example.jetpackcomposedemo.state

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay

// LaunchEffect is called when the key parameter value changes and it also provides coroutine scope
// Use when you want to execute block of code only once or when key value changes
@Composable
fun LaunchEffectHandler() {
    val count = remember { mutableIntStateOf(0) }

    // Here the block of code is only executes if the key value changes
    LaunchedEffect(key1 = false) {
        Log.e("SideEffect", "Launched Effect called - Counter ${count.intValue}")
    }

    Button(onClick = { count.intValue++ }) {
        Text("Increment Count")
    }
}

// Problems while using LaunchedEffect
// Prob 1: LaunchedEffect is composable it only calls inside composable (Try calling inside button click)
// Prob 2: LaunchedEffect is called multiple times whenever recomposition occurs
@Composable
fun LaunchedEffectProblem() {
    val count = remember { mutableIntStateOf(0) }

    // Prob 1: LaunchedEffect is composable it only calls inside composable
    // Button(onClick = { LaunchedEffect()  { }}) { }

    // Prob 2: LaunchedEffect is called multiple times whenever recomposition occurs
    // Try changing configuration before counter reached to 10
    // When changing configuration or the recomposition occurs in between then the
    // LaunchedEffect will dispose old scope and create new scope (To helps prevent memory leaks)
    LaunchedEffect(key1 = Unit) {
        Log.e("LaunchedEffect", "Started...")

        try {
            for (i in 1..10) {
                count.intValue++
                delay(1000)
            }
        } catch (e: Exception) {
            Log.e("LaunchedEffect", "Exception: ${e.message}")
        }
    }

    var text = "Counter is running ${count.intValue}"
    if (count.intValue == 10) {
        text = "Counter stopped."
    }
    Text(text)
}