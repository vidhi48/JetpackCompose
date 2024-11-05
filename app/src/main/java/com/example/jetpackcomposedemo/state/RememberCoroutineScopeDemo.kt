package com.example.jetpackcomposedemo.state

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun RememberCoroutineScope(context: Context) {
    val scope = rememberCoroutineScope()
    Button(
        onClick = {
            scope.launch {
                Toast.makeText(context, "This is a toast message", Toast.LENGTH_SHORT).show()
            }
        }
    ) {
        Text("RememberCoroutineScope")
    }
}