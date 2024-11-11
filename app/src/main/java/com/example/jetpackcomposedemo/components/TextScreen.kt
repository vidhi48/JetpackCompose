package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemo.R

@Preview
@Composable
fun TextScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp, start = 8.dp, end = 8.dp)
    ) {
        TextDemo()
        MultiLineText()
        LongText()
        TextFieldDemo()
        OutlinedTextFieldDemo()
        DropDownScreen()
    }
}

@Composable
fun TextDemo() {
    Text(
        stringResource(R.string.text_demo),
        color = Color.Blue,
        fontSize = 20.sp,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline,
        )
}

@Composable
fun MultiLineText() {
    Text(
        modifier = Modifier.padding(top = 15.dp),
        text = buildAnnotatedString {
            append("Dp not allow people to dim your shine\n")
            withStyle(
                SpanStyle(
                    brush = Brush.linearGradient(
                        colors = listOf(Color.Red, Color.Blue)
                )
            )
            ) {
                append("because they are blinded.")
            }
            append("\n Tell them to put sunglasses on.")
        }
    )
}

@Composable
fun LongText() {
    Text(
        modifier = Modifier.padding(top = 15.dp),
        text = "Hello".repeat(50),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        color = Color.Red
    )
}

@Composable
fun TextFieldDemo() {
    var text by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
        value = text,
        onValueChange = { text = it },
        label = { Text(stringResource(R.string.enter_number)) },
        placeholder = { Text(stringResource(R.string.enter_number)) },
        leadingIcon = {
            Icon(Icons.Filled.Edit, contentDescription = "")
        },
        trailingIcon = {
            Icon(Icons.Filled.Person, contentDescription = "")
        },
        textStyle = TextStyle(color = Color.Blue, fontSize = 15.sp),
        maxLines = 2,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun OutlinedTextFieldDemo() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
        value = text,
        onValueChange = { text = it },
        label = { Text(stringResource(R.string.password)) },
        placeholder = { Text("Enter password") },
        leadingIcon = {
            Icon(Icons.Filled.Edit, contentDescription = "")
        },
        trailingIcon = {
            Icon(Icons.Filled.Person, contentDescription = "")
        },
        maxLines = 2,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}