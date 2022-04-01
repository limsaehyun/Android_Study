package com.saehyun.clonedesign.ui.signIn

import android.content.ContentValues.TAG
import android.text.Layout
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saehyun.clonedesign.R
import com.saehyun.clonedesign.component.DefaultButton
import com.saehyun.clonedesign.component.WhiteBox
import com.saehyun.clonedesign.theme.CloneDesignTheme
import com.saehyun.clonedesign.theme.Gray2
import com.saehyun.clonedesign.theme.Mint
import com.saehyun.clonedesign.theme.Typography

@Composable
fun SignInUI() {

    var buttomColor by rememberSaveable { mutableStateOf(true) }

    CloneDesignTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopBox()

            Surface(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxHeight()
                    .wrapContentSize(align = Alignment.BottomStart)
            ) {
                DefaultButton(
                    onClick = { Log.d(TAG, "SignInUI: ") },
                    isFinished = buttomColor,
                    title = "로그인"
                )
            }
        }
    }
}

@Composable
fun TopBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Mint)
    ) {
        Column(
            modifier = Modifier.padding(start = 24.dp, top = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_bug),
                contentDescription = "icon",
                modifier = Modifier.size(60.dp, 60.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "DMS for Android", color = Color.White, style = Typography.body1)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpUI() {
    SignInUI()
}