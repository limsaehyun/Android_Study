package com.saehyun.clonedesign.ui.mypage

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saehyun.clonedesign.R
import com.saehyun.clonedesign.bottomNave.MintBox
import com.saehyun.clonedesign.component.ImageIconButton
import com.saehyun.clonedesign.component.MyPageTextBar
import com.saehyun.clonedesign.component.WhiteBox
import com.saehyun.clonedesign.theme.Mint

@Composable
fun MyPageScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        MyPageTopScreen()

        Spacer(modifier = Modifier.size(20.dp))
        
        MintBox(text = "퇴사가 오늘 내일한다.")

        Spacer(modifier = Modifier.size(20.dp))

        MyPageBottomMenu()

    }
}

@Composable
fun MyPageBottomMenu() {
    val context = LocalContext.current

    Column {
        MyPageTextBar(
            onClick = { Toast.makeText(context, "click", Toast.LENGTH_SHORT).show() },
            title = "로그아웃",
            lore = "기기내 계정에서 로그아웃합니다"
        )

        MyPageTextBar(
            onClick = { Toast.makeText(context, "click", Toast.LENGTH_SHORT).show() },
            title = "비밀번호 변경",
            lore = "DMS 계정의 비밀번호를 변경합니다"
        )

        MyPageTextBar(
            onClick = { Toast.makeText(context, "click", Toast.LENGTH_SHORT).show() },
            title = "상 / 벌점 내역",
            lore = "우정관 상/ 벌점 내역을 확인합니다"
        )

        MyPageTextBar(
            onClick = { Toast.makeText(context, "click", Toast.LENGTH_SHORT).show() },
            title = "개발자 소개",
            lore = "DMS팀의 개발자를 소개합니다"
        )
    }
}

@Composable
fun MyPageTopScreen() {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.white)),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(158.dp)
                .background(Mint)
        ) {
            Column(
                modifier = Modifier.padding(start = 20.dp, top = 16.dp)
            ) {
                Text(
                    text = "홍길동",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "1315",
                    color = Color(0xFF94D5D6),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            Row(
                Modifier
                    .padding(top = 48.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                ImageIconButton(
                    onClick = { Toast.makeText(context, "click", Toast.LENGTH_SHORT).show() },
                    title = "시설 고장 신고",
                    painter = painterResource(id = R.drawable.ic_report)
                )

                Spacer(modifier = Modifier.size(40.dp))

                ImageIconButton(
                    onClick = { Toast.makeText(context, "click", Toast.LENGTH_SHORT).show() },
                    title = "설문조사",
                    painter = painterResource(id = R.drawable.ic_pen)
                )

                Spacer(modifier = Modifier.size(40.dp))

                ImageIconButton(
                    onClick = { Toast.makeText(context, "click", Toast.LENGTH_SHORT).show() },
                    title = "버그 신고",
                    painter = painterResource(id = R.drawable.ic_bug)
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 110.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            WhiteBox(title = "30", lore = "상점")

            Spacer(modifier = Modifier.size(16.dp))

            WhiteBox(title = "30", lore = "벌점")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyPageScreen() {
    MyPageScreen()
}