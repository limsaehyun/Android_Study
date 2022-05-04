package com.saehyun.clonedesign.ui.mypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.saehyun.clonedesign.R
import com.saehyun.clonedesign.theme.Mint

@Composable
fun WarningListUI(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Mint),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "back button",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { navController.popBackStack() }
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "상벌점 내역 조회", color = Color.White)
        }
    }
}