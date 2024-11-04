package com.example.jetpackcomposedemo.state

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Official link to understand state https://developer.android.com/develop/ui/compose/state

// This composable is stateful composable as it has state variable
@Preview
@Composable
fun NotificationScreen() {

    // I hosted count variable as I want to share the value of count variable in both of the composable
    val count = rememberSaveable { mutableIntStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)) {
        NotificationCounter(count.intValue, increment = { count.intValue++ })
        MessageBar(count.intValue)
    }
}

// This composable is stateless composable as it has no state variable
@Composable
fun NotificationCounter(count: Int, increment: () -> Int) {
    // Here this variable lost value when we rotate the device because when we rotate the composition is destroyed
    //val count: MutableState<Int> = remember { mutableIntStateOf(0)  }

    // This rememberSaveable will save the value in a bundle
    // val count = rememberSaveable { mutableIntStateOf(0) }

    Column (verticalArrangement = Arrangement.Center) {
        Text(text = "You have sent $count notifications.")
        Button(onClick = { increment() }) {
            Text(text = "Send Notification")
        }
    }
}

@Composable
fun MessageBar(count: Int) {
    Card (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row (
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = "",
                Modifier.padding(4.dp)
            )
            Text("Message sent so far - $count")
        }
    }
}