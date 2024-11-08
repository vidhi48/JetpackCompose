package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemo.R

@Composable
fun CardScreen() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp, top = 100.dp),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.White,
            disabledContentColor = Color.Black
        ),
        border = BorderStroke(width = 1.dp, color = Color.Black)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Card(
                modifier = Modifier.padding(15.dp),
                colors = CardColors(
                    containerColor = colorResource(R.color.lightBlue),
                    contentColor = Color.Black,
                    disabledContainerColor = Color.Blue,
                    disabledContentColor = Color.Black
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.banana),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .width(57.dp)
                        .height(57.dp)
                )
            }
            Column {
                Text(stringResource(R.string.banana), fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(stringResource(R.string.temp), fontSize = 15.sp, color = colorResource(R.color.darkGreen))
            }
        }
    }
}