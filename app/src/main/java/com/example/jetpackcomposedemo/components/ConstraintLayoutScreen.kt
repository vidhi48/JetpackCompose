package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcomposedemo.R

@Preview
@Composable
fun ConstraintLayoutScreen() {
    Card(
        modifier = Modifier.padding(12.dp)
    ) {
        ConstraintLayout {
            val (card, column) = createRefs()
            val startGuideLine = createGuidelineFromStart(0.01f)

            Card(
                modifier = Modifier
                    .constrainAs(card) {
                        top.linkTo(parent.top)
                        start.linkTo(startGuideLine)
                    }
                    .padding(12.dp)
                    .background(colorResource(R.color.lightBlue))
            ) {
                Image(
                    painter = painterResource(R.drawable.banana),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(10.dp)
                        .height(42.dp)
                        .width(42.dp)
                )
            }

            Column(
                modifier = Modifier
                    .constrainAs(column) {
                        start.linkTo(card.end)
                        centerVerticallyTo(card)
                    }
                    .padding(12.dp)
            ) {
                Text(
                    "Banana",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold))
                )

                Text(
                    "1° C I 29 MT  I 65.0% I 15.0",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    color = colorResource(R.color.darkGreen)
                )
            }
        }
    }
}
