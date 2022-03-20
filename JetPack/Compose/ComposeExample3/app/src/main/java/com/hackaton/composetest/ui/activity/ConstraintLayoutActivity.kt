package com.hackaton.composetest.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import com.hackaton.composetest.ui.theme.ComposeTestTheme

class ConstraintLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                Surface(color = MaterialTheme.colors.background) {
                    TestConstraints()
                }
            }
        }
    }
}

@Composable
fun TestConstraints() {
    Row {
        ConstraintLayoutContent()

        Spacer(modifier = Modifier.padding(16.dp))

        DecoupledConstraintLayout()
    }
}

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        val (button1, text) = createRefs()

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text(text = "Button1")
        }
        
        Text(
            text = "Hello",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(button1.bottom, margin = 16.dp)
                centerHorizontallyTo(parent)
            }
        )
    }
}

@Composable
private fun decoupledConstraints(margin: Dp) =
    ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            top.linkTo(parent.top, margin)
        }

        constrain(text) {
            top.linkTo(button.bottom, margin)
        }
    }

@Composable
private fun DecoupledConstraintLayout() {
    BoxWithConstraints {
        val constrains = if(minWidth < 600.dp) {
            decoupledConstraints(margin = 16.dp)
        } else {
            decoupledConstraints(margin = 16.dp)
        }

        ConstraintLayout(constrains) {
            Button(
                onClick = { /*아무말*/ },
                modifier = Modifier.layoutId("button")
            ) {
                Text("button")
            }

            Text("Text", modifier = Modifier.layoutId("text") )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    ComposeTestTheme {
        TestConstraints()
    }
}