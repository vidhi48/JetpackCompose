package com.example.jetpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.jetpackcomposedemo.components.AvailRateScreen
import com.example.jetpackcomposedemo.components.NavigationDrawerScreen
import com.example.jetpackcomposedemo.components.SliderScreen
import com.example.jetpackcomposedemo.components.SnackBarScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    NotificationScreen()
//                    SideEffectHandlerScreen()
//                    ComposableListScreen()
                SnackBarScreen()
            }
        }
    }
}