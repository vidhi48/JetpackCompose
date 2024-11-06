package com.example.jetpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.jetpackcomposedemo.components.AppBarScreen
import com.example.jetpackcomposedemo.components.BadgeScreen
import com.example.jetpackcomposedemo.components.BottomSheetScreen
import com.example.jetpackcomposedemo.components.ButtonsScreen
import com.example.jetpackcomposedemo.components.CardScreen
import com.example.jetpackcomposedemo.components.ComposableListScreen
import com.example.jetpackcomposedemo.state.NotificationScreen
import com.example.jetpackcomposedemo.state.SideEffectHandlerScreen
import com.example.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    NotificationScreen()
//                    SideEffectHandlerScreen()
//                    ComposableListScreen()
                    CardScreen()
                }
            }
        }
    }
}