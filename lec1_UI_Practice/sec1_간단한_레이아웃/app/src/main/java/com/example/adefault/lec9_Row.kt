package com.example.adefault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.adefault.ui.theme.AdefaultTheme

class lec9_Row : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdefaultTheme {
                RowText()
            }
        }
    }
}

@Composable
fun RowText() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        horizontalArrangement = Arrangement.SpaceEvenly, // 가로로 동일한 간격
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            text = "Item1",
            style = TextStyle(background = Color.Blue),
            fontSize = 30.sp,
        )
        Text(
            text = "Item2",
            style = TextStyle(background = Color.Red),
            fontSize = 30.sp,
        )
        Text(
            text = "Item3",
            style = TextStyle(background = Color.Green),
            fontSize = 30.sp,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun Preview9() {
    AdefaultTheme {
        RowText()
    }
}