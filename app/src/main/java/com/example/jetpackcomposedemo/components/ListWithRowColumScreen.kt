package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemo.R
import com.example.jetpackcomposedemo.components.models.getVesselList

@Composable
fun ListWithRowColumScreen() {
    // This will not recycling the views
    Column(modifier = Modifier.padding(top = 50.dp)) {
        Text(text = stringResource(R.string.vessel_list), fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(start = 16.dp))
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(start = 16.dp, top = 5.dp)
        ) {
            getVesselList().forEach { item ->
                VesselList(title = item.title, subtitle = item.subtitle)
            }
        }
        Text(text = stringResource(R.string.vessel_list), fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(start = 16.dp, top = 15.dp))
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(start = 16.dp, top = 5.dp)
        ) {
            getVesselList().forEach { item ->
                VesselList(title = item.title, subtitle = item.subtitle)
            }
        }
    }
}

@Composable
fun VesselList(title: String, subtitle: String) {
    Card(
        modifier = Modifier.padding(end = 8.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.lightGreen)),
        border = BorderStroke(width = 1.dp, color = colorResource(R.color.darkGreen))
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, fontWeight = FontWeight.Bold)
            Text(text = subtitle, fontWeight = FontWeight.Thin, fontSize = 12.sp,
                modifier = Modifier.padding(top = 6.dp))
        }
    }
}

@Preview
@Composable
fun ScheduleList() {
    Card (
        modifier = Modifier.padding(end = 16.dp, top = 12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(top = 10.dp, start = 32.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.navio),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 23.dp, end = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = stringResource(R.string._28_jul), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    Column(modifier = Modifier.padding(start = 5.dp)) {
                        Text(text = stringResource(R.string._6_days), fontSize = 10.sp)
                        Image(
                            painter = painterResource(id = R.drawable.arrow),
                            contentDescription = "",
                            modifier = Modifier.size(width = 50.dp, height = 10.dp),
                            contentScale = ContentScale.FillBounds
                        )
                        Text(text = stringResource(R.string.direct), fontSize = 10.sp)
                    }
                    Text(text = stringResource(R.string._31_jul), fontWeight = FontWeight.Bold, fontSize = 12.sp)

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = stringResource(R.string._2_535), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        Text(text = stringResource(R.string.freight), fontSize = 8.sp)
                    }
                }
            }

            HorizontalDivider(modifier = Modifier.padding(start = 22.dp, end = 22.dp, top = 15.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, top = 15.dp, bottom = 16.dp, end = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = stringResource(R.string.inventory_status), fontSize = 9.sp)
                    Text(text = stringResource(R.string.confirmed_do), fontSize = 11.sp)
                }

                Button(
                    onClick = {},
                    colors = ButtonColors(
                        containerColor = colorResource(R.color.darkGreen),
                        contentColor = Color.White,
                        disabledContainerColor = Color.Black,
                        disabledContentColor = Color.Black
                    )
                ) {
                    Text(text = stringResource(R.string.check_full_quote))
                }
            }
        }
    }
}