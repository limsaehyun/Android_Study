package com.saehyun.clonedesign.component

import androidx.compose.foundation.layout.*
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

@Composable
fun MintBox(
    text: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .padding(start = 17.dp, end = 17.dp),
        shape = RoundedCornerShape(30.dp),
        backgroundColor = Mint,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun PreviewMintBox() {
    MintBox("퇴사가 오늘 내일한다.")
}