package com.example.jetpackcomposedemo.state

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun DisposableEffectScreen() {
    val state = remember { mutableStateOf(false) }

    DisposableEffect(key1 = state.value) {
        Log.d("DisposableEffect", "Disposable Effect called")

        // this will called when recomposition occurs because at that old compose will dispose and new will initialize
        onDispose {
            Log.d("DisposableEffect", "Disposable Effect disposed")
        }
    }

    Button(onClick = { state.value = !state.value }) {
        Text("DisposableEffect")
    }
}