package com.test.fff

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.transition.MaterialSharedAxis
import com.test.fff.ui.theme.MyApplicationTheme

class QuadrantActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantPage()
//            Text("hello world");
        }
    }
}

@Composable
@Preview(showBackground = true)
fun QuadrantPage() {
    //androidx.compose.ui.graphics.Color.Green
    //androidx.compose.ui.graphics.Color.Yellow
    //androidx.compose.ui.graphics.Color.Cyan
    //androidx.compose.ui.graphics.Color.LightGray

    //Text composable
    //Displays text and follows Material Design guidelines.
    //Image composable
    //Creates a composable that lays out and draws a given Painter class object.
    //Row composable
    //A layout composable that places its children in a horizontal sequence.
    //Column composable
    //A layout composable that places its children in a vertical sequence.
    MyApplicationTheme() {
        Column(modifier = Modifier.fillMaxSize()) {
            val configuration = LocalConfiguration.current
            Row(Modifier.weight(1f)) {
                Item(
                    "Text composable", "Displays text and follows Material Design guidelines.",
                    Modifier
                        .weight(1f), androidx.compose.ui.graphics.Color.Green
                )
                Item(
                    "Text composable", "Displays text and follows Material Design guidelines.",
                    Modifier
                        .weight(1f), androidx.compose.ui.graphics.Color.Yellow
                )
            }
            Row(Modifier.weight(1f)) {
                Item(
                    "Text composable", "Displays text and follows Material Design guidelines.",
                    Modifier
                        .weight(1f), androidx.compose.ui.graphics.Color.Cyan
                )
                Item(
                    "Text composable", "Displays text and follows Material Design guidelines.",
                    Modifier
                        .weight(1f), androidx.compose.ui.graphics.Color.LightGray
                )
            }
        }
    }
}

@Composable
fun Item(title: String, des: String, modifier: Modifier = Modifier, color: Color) {
    Column(
        modifier = modifier
            .background(color)
            .fillMaxSize()
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            text = title
        )
        Text(text = des, textAlign = TextAlign.Justify)
    }
}