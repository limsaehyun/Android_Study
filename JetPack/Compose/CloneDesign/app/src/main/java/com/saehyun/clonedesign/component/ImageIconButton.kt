package com.saehyun.clonedesign.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saehyun.clonedesign.R

@Composable
fun ImageIconButton(
    onClick: () -> Unit,
    title: String,
    painter: Painter
) {
    Column(
        modifier = Modifier
            .size(48.dp, 40.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painter,
            tint = Color.White,
            contentDescription = "icon"
        )
        Text(
            text = title,
            fontSize = 8.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentHeight(Alignment.Bottom)
        )
    }
}

@Preview
@Composable
fun PreviewIamgeIconButton() {
    ImageIconButton(
        onClick = {},
        "시설 고장 신고",
        painterResource(id = R.drawable.ic_report)
    )
}