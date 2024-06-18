package com.example.adefault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.adefault.ui.theme.AdefaultTheme

class lec18_CodeEditing : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdefaultTheme {
                MyTextArea3()
            }
        }
    }
}

@Composable
fun MyTextArea1() {
    Column {
        Text(
            text = "안녕", fontSize = 100.sp, color = Color.Red
        )
        Text(
            text = "나는", fontSize = 100.sp, color = Color.Gray
        )
        Text(
            text = "누구야", fontSize = 100.sp, color = Color.Green
        )
    }
}

@Composable
fun MyTextArea2() {
    Column {
        MyTextFormat1("안녕", 100.sp, Color.Red)
        MyTextFormat1("안녕", 100.sp, Color.Green)
        MyTextFormat1("안녕", 100.sp, Color.Gray)
    }
}

@Composable
fun MyTextFormat1(text: String, fontSize: TextUnit, color: Color) {
    Text(
        text = text, fontSize = fontSize, color = color
    )
}

@Composable
fun MyTextArea3() {
    MyTextFormat2 {
        Text(text = "안녕", fontSize = 100.sp, color = Color.Red)
    }
}

@Composable
fun MyTextFormat2(content: @Composable () -> Unit) {
    Column {
        content()
        content()
        content()
        content()
        content()
    }
}


@Preview(showBackground = true)
@Composable
fun Preview18() {
    AdefaultTheme {
        MyTextArea3()
    }
}