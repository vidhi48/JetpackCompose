package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemo.R

@Composable
fun BadgeScreen() {
    val itemCount = remember { mutableIntStateOf(0) }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BadgedBox(badge = {
            if (itemCount.intValue > 0) {
                Badge(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ) {
                    Text(text = itemCount.intValue.toString())
                }
            }
        }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping cart"
            )
        }
        Button(onClick = { itemCount.intValue++} ) {
            Text(text = stringResource(R.string.add_to_cart))
        }
    }
}