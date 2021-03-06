package com.saehyun.clonedesign.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saehyun.clonedesign.theme.Mint
import com.saehyun.clonedesign.theme.coloredShadow

@Composable
fun WhiteBox(
    title: String,
    lore: String
) {
    Card(
        modifier = Modifier
            .background(
                shape = RoundedCornerShape(15.dp),
                color = Color.White
            )
            .size(153.dp, 67.dp)
            .coloredShadow(color = Mint, offsetY = 2.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                text = lore,
                fontWeight = FontWeight.Normal,
                fontSize = 9.sp,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWhiteBox() {
    WhiteBox(
        "30",
        "상점"
    )
}

