package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemo.components.models.getVesselList

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AvailRateScreen() {
   Scaffold(
       topBar = {
           TopAppBar(
               title = {
                   Text(text = "Avail Rate", fontWeight = FontWeight.Bold, fontSize = 16.sp)
               },
               navigationIcon = {
                   IconButton(onClick = { /* doSomething() */ }) {
                       Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Localized description")
                   }
               },
               actions = {
                   IconButton(onClick = { /* doSomething() */ }) {
                       Icon(Icons.Filled.Person, contentDescription = "Localized description")
                   }
               },
               colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
           )
       }
   ) { innerPadding ->
       Column(
           modifier = Modifier.padding(top = 90.dp, bottom = 15.dp, start = 16.dp)
       ) {
           Text("Vessel List", fontWeight = FontWeight.Bold, fontSize = 20.sp)
           LazyRow(modifier = Modifier.padding(top = 8.dp)) {

               // Use item when we want to display single item
               item {
                   getVesselList().forEach { item ->
                       VesselList(item.title, item.subtitle)
                   }
               }

               // Use this when you don't have an id in model but want to use index inside item
               /*itemsIndexed(getVesselList()) { index, item ->
                   VesselList(item.title, item.subtitle)
               }*/
           }

           Text("Schedule List", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(top = 25.dp))
           LazyColumn() {
               items(15) {
                   ScheduleList()
               }
           }
       }
   }
}