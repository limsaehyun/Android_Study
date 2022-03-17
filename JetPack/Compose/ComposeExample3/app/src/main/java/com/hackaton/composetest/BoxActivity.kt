package com.hackaton.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hackaton.composetest.ui.theme.Blue
import com.hackaton.composetest.ui.theme.ComposeTestTheme

class BoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    TestComposable()
                }
            }
        }
    }
}

@Composable
fun TextWithPaddingFromBaseline() {
    Box(modifier = Modifier.background(Color.Yellow)) {
        Text(text = "TextWithPaddingFromBaseLine", modifier = Modifier.paddingFromBaseline(32.dp))
    }
}

@Composable
fun TestComposable() {
    Column(modifier = Modifier.padding(16.dp)) {
        // 지정한 크기가 레이아웃의 상위 요소를 무시하고 Composable의 크기를 고정해야 하는 경우 requiredSize 수정자를 사용
        FixedSizeComposable()

        Spacer(modifier = Modifier.size(16.dp))

        // 레이아웃의 상위 요소 크기에 상위요소가 허용하는 만큼 하위요소가 꽉 채우고 싶은 경우
        FillSizeComposable()

        Spacer(modifier = Modifier.size(16.dp))

        // 상위 레이아웃과 동일한 크기로 설정
        MatchParentSizeComposable()

        Spacer(modifier = Modifier.size(16.dp))

        // 레이아웃 상단에서 기준선까지 특정 거리가 유지되도록 패딩을 추가하려면 paddingFromBaseline 수정자를 사용
        TextWithPaddingFromBaseline()

        Spacer(modifier = Modifier.size(16.dp))

        // offset 수정자를 추가해서 x축 , y축을 설정해서 사용함
        OffsetComposable()

        Spacer(modifier = Modifier.size(16.dp))

        // 상위 요소의 제약 조건에 따라 레이아웃을 디자인하려면 BoxWithConstraints를 사용
        WithConstraintsComposable()
    }
}

@Composable
fun FixedSizeComposable() {
    Box(
        modifier = Modifier
            .size(90.dp, 150.dp)
            .background(Color.Yellow)
    ) {
        Box(
            modifier = Modifier
                .requiredSize(100.dp, 100.dp)
                .background(Color.Red)
        )
    }
}

@Composable
fun MatchParentSizeComposable() {
    Box {
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Blue)
        )
        Column() {
            Text(text = "Hello World")
            Text(text = "Hello World")
        }
    }
}

@Composable
fun FillSizeComposable() {
    Box(
        Modifier
            .background(Color.Green)
            .size(50.dp)
            .padding(10.dp)
    ) {
        Box(
            Modifier
                .background(Color.Blue)
                .fillMaxSize()
        )
    }
}

@Composable
fun OffsetComposable() {
    Box(
        Modifier
            .background(Color.Yellow)
            .size(width = 150.dp, height = 70.dp)
    ) {
        Text(
            "Layout offset modifier sample",
            Modifier.offset(x = 15.dp, y = 20.dp)
        )
    }
}

@Composable
fun WithConstraintsComposable() {
    BoxWithConstraints {
        Text(
            text ="max height : $maxHeight min height : $minHeight",
            fontSize = 24.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    ComposeTestTheme {
        TestComposable()
    }
}