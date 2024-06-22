package com.example.adefault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adefault.ui.theme.AdefaultTheme

class lec26_Canvas : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdefaultTheme {
                MyCanvas()
            }
        }
    }
}

@Composable
fun MyCanvas() {
//    Box(
//        modifier = Modifier
//            .size(50.dp)
//            .background(Color.Green)
//    ) {
//        Canvas(modifier = Modifier.fillMaxSize()) {
//            drawCircle(Color.Black, radius = size.minDimension / 10)
//        }
//    }

    Box(
        modifier = Modifier
            .width(100.dp)
            .height(200.dp)
            .background(Color.Green)
    ) {
        Canvas(
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.Center)
        ) {
            drawCircle(Color.Black, radius = size.minDimension / 2)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview26() {
    AdefaultTheme {
        MyCanvas()
    }
}