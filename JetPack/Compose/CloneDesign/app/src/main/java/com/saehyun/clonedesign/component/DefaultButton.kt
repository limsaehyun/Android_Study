package com.saehyun.clonedesign.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saehyun.clonedesign.theme.Gray1
import com.saehyun.clonedesign.theme.Gray2
import com.saehyun.clonedesign.theme.Mint
import com.saehyun.clonedesign.theme.Typography

@Composable
fun DefaultButton(
    onClick: () -> Unit,
    isFinished: Boolean,
    title: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(start = 17.dp, end = 17.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        backgroundColor = if(isFinished) Gray1 else Gray2
    ) {
        Text(text = title, modifier = Modifier.wrapContentHeight(CenterVertically), textAlign = TextAlign.Center, style = Typography.body1, color = Color.White)
    }
}

@Preview
@Composable
fun PreviewDefaultButton() {
    DefaultButton(onClick = { }, true, title = "로그인")
}