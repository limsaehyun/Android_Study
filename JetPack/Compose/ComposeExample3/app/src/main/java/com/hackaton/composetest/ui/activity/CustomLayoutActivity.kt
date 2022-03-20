package com.hackaton.composetest.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hackaton.composetest.ui.theme.ComposeTestTheme

class CustomLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Row {
                        TextWithPaddingToBaselinePreview()
                        TextWithNormalPaddingPreview()
                        CallingComposable()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TextWithPaddingToBaselinePreview() {
    Text("Hi there!", Modifier.firstBaselineToTop(32.dp))
}
@Preview
@Composable
fun TextWithNormalPaddingPreview() {
    Text("Hi there!", Modifier.padding(top = 32.dp))
}


fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = layout { measurable, constraints ->
    // 파라미터에 측정할 수 있는 요소 : measurable
    // Composable에 수식된 제약조건 constraints

    val placeable = measurable.measure(constraints)

    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
    val firstBaseline = placeable[FirstBaseline]

    val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
    val height = placeable.height + placeableY
    layout(placeable.width, height) {

        placeable.placeRelative(0, placeableY)
    }
}

@Composable
fun MyBasicColumn(
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val placeables = measurables.map {
            it.measure(constraints)
        }

        layout(constraints.maxWidth, constraints.maxHeight) {
            var yPosition = 0

            placeables.forEach { placeable ->
                placeable.placeRelative(x = 0, y = yPosition)
                yPosition += placeable.height
            }
        }
    }
}

@Composable
fun CallingComposable(modifier: Modifier = Modifier) {
    MyBasicColumn(modifier.padding(8.dp)) {
        Text("MyBasicColumn")
        Text("places items")
        Text("vertically.")
        Text("We've done it by hand!")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    ComposeTestTheme {
        Row {
            TextWithPaddingToBaselinePreview()
            TextWithNormalPaddingPreview()
            CallingComposable()
        }
    }
}