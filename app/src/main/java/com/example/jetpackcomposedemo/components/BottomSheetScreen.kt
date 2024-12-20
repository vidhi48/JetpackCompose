package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScreen() {
    // If skipPartiallyExpanded property is set to true then it will open to full screen otherwise giving swipe option in sheet
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val showBottomSheet = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { showBottomSheet.value = true }
        ) {
            Text(stringResource(R.string.open_bottomsheet))
        }
        if (showBottomSheet.value) {
            ModalBottomSheet(
                modifier = Modifier.fillMaxHeight(),
                onDismissRequest = { showBottomSheet.value = false },
                sheetState = sheetState
            ) {
                Column(
                    modifier = Modifier.padding(top = 50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(stringResource(R.string.bottom_sheet_content), fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Button(onClick = { showBottomSheet.value = false }) {
                        Text(stringResource(R.string.close_bottom_sheet))
                    }
                }
            }
        }
    }
}