package com.test.note2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.note2.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPage()
                }
            }
        }
    }
}

@Composable
fun MainPage() {
    var navSel by remember {
        mutableStateOf(1)
    }
    Text(text = "测试")
    Row() {
        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom
        ) {
            BottomNav(sel = navSel, onClick1 = { navSel = 1 }, onClick2 = { navSel = 2 })
        }
    }

}

@Composable
fun BottomNav(
    imageHeight: Dp = 30.dp,
    fontSize: TextUnit = 10.sp,
    navHeight: Dp = 60.dp,
    sel: Int,
    onClick1: () -> Unit,
    onClick2: () -> Unit
) {
    var nav1_resource_id = R.drawable.nav_1_main_thin
    var nav2_resource_id = R.drawable.nav_2_calendar_thin
    var fontWeight1 = FontWeight.Light
    var fontWeight2 = FontWeight.Light
    if (sel == 1) {
        nav1_resource_id = R.drawable.nav_1_main
        fontWeight1 = FontWeight.Bold
    } else {
        nav2_resource_id = R.drawable.nav_2_calendar
        fontWeight2 = FontWeight.Bold
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(navHeight),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        NavItem(contentId = R.string.nav1_label,imageHeight=imageHeight, fontSize = fontSize, onClick = onClick1, nav_resource_id = nav1_resource_id, fontWeight = fontWeight1)
        NavItem(contentId = R.string.nav2_label,imageHeight=imageHeight, fontSize = fontSize, onClick = onClick2, nav_resource_id = nav2_resource_id, fontWeight = fontWeight2)
    }
}

@Composable
fun NavItem(
    contentId: Int,
    onClick: () -> Unit,
    nav_resource_id: Int,
    imageHeight: Dp,
    fontSize: TextUnit,
    color: Color = MaterialTheme.colorScheme.primary,
    fontWeight: FontWeight = FontWeight.Black
) {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        onClick = onClick
    ) {
        Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.size(imageHeight),
                painter = painterResource(id = nav_resource_id),
                contentDescription = ""
            )
            Text(stringResource(id = contentId), fontSize = fontSize, color = color, fontWeight = fontWeight)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        MainPage()
    }
}