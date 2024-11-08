package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemo.R
import com.example.jetpackcomposedemo.helpers.TextButtonWithIcons
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawerScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerContentScreen()
            }
        }
    ) {
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text(stringResource(R.string.show_drawer)) },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            }
        ) { contentPadding ->

        }
    }
}

@Preview
@Composable
fun NavigationDrawerContentScreen() {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(color = colorResource(R.color.lightGreen))
        ) {
            Image(
                painter = painterResource(R.drawable.woman),
                contentDescription = "",
                modifier = Modifier
                    .size(width = 100.dp, height = 100.dp)
                    .padding(start = 15.dp)
            )
            Column(
                modifier = Modifier.padding(start = 15.dp)
            ) {
                Text(stringResource(R.string.vidhi_patel), fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(stringResource(R.string.test_hotmail_com), fontSize = 14.sp, fontWeight = FontWeight.Thin)
                Text(stringResource(R.string.mobileNo), fontSize = 14.sp, fontWeight = FontWeight.Thin)
            }
        }

        TextButton(
            onClick = { }
        ) {
            TextButtonWithIcons(text = stringResource(R.string.profile), icon = Icons.Filled.Person, onClick = {})
        }
        TextButton(
            onClick = { }
        ) {
            TextButtonWithIcons(stringResource(R.string.settings), Icons.Filled.Settings, {})
        }
        TextButton(
            onClick = { }
        ) {
            TextButtonWithIcons(stringResource(R.string.chat), Icons.Outlined.Send, {})
        }
        HorizontalDivider()
        TextButton(
            onClick = { }
        ) {
            TextButtonWithIcons(stringResource(R.string.logout), Icons.Filled.Lock, {})
        }
    }
}