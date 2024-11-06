package com.example.jetpackcomposedemo.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SideEffectHandlerScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        Text("Side Effect: ", fontWeight = FontWeight.Bold, color = Color.Red)
        SideEffectProblem()
        Spacer(modifier = Modifier.height(15.dp))

        Text("Launched Effect: ", fontWeight = FontWeight.Bold, color = Color.Red)
        LaunchEffectHandler()
        LaunchedEffectProblem()
        Spacer(modifier = Modifier.height(15.dp))

        RememberCoroutineScope(context = LocalContext.current)
        RememberUpdatedStateScreen()
        DisposableEffectScreen()
    }
}

// what is side effect?
@Composable
fun SideEffectProblem() {
    val categoryState = remember { mutableStateOf(emptyList<String>()) }

    // Prob 1: It will call multiple times whenever recomposition occurs
    // Prob 2: Network call can take time to fetch data from server and because of that UI can freeze
    categoryState.value = fetchCategories()

    // Solution: Use side effect handle
    // Use this flow instead of above as it will call on background thread as it has coroutine scope
    // and it will call only once
    LaunchedEffect(key1 = false) {
        categoryState.value = fetchCategories()
    }

    LazyColumn {
        items(categoryState.value.size) { index ->
            Text(text = categoryState.value[index])
        }
    }
}

fun fetchCategories(): List<String> {
    // Assume list is coming from from API or database
    return listOf("Category 1", "Category 2", "Category 3")
}