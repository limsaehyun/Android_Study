package com.saehyun.clonedesign.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saehyun.clonedesign.R
import com.saehyun.clonedesign.theme.Mint

@Composable
fun MyPageTextBar(
    onClick: () -> Unit,
    title: String,
    lore: String
) {
    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp)
            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Mint
            )
            Text(
                text = lore,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                color = Color.Black
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_next),
            contentDescription = "icon",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
                .align(Alignment.CenterEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyPageTextBar() {
    MyPageTextBar({}, "로그아웃", "기기내 계정에서 로그아웃합니다")
}
