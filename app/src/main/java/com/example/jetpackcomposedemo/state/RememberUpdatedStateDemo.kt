package com.example.jetpackcomposedemo.state

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

// Use when you want to display updated value
@Composable
fun RememberUpdatedStateScreen() {
    val state = remember { mutableStateOf(::a) }
    Button(onClick = { state.value = ::b }) {
        Text("RememberUpdatedState")
    }
    LandingScreen(state.value)
}

@Composable
fun LandingScreen(onTimeout: () -> Unit) {
    // Here if you don't use rememberUpdatedState than it will not display updatedValue
    val currentOnTimeout by rememberUpdatedState(onTimeout)
   LaunchedEffect(true) {
       delay(5000)
       currentOnTimeout()
   }
}

fun a() { Log.d("rememberUpdatedState:", "I am A") }
fun b() { Log.d("rememberUpdatedState:", "I am B") }