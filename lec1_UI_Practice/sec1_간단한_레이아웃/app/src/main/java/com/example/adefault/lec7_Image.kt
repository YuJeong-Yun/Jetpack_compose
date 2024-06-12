package com.example.adefault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.adefault.ui.theme.AdefaultTheme

class lec7_Image : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdefaultTheme {
                MyImageTest2()
            }
        }
    }
}

// drawable에 있는 이미지
@Composable
fun MyImageTest1() {
    Image(
        painter = painterResource(id = R.drawable.img),
        contentDescription = "bok"
    )
}

// 웹에 있는 이미지
@Composable
fun MyImageTest2() {
    AsyncImage(
        model = "https://cdn.imweb.me/upload/S201910012ff964777e0e3/62f9a36ea3cea.jpg",
        contentDescription = "강아지",
        modifier = Modifier.fillMaxSize()
    )
}


@Preview(showBackground = true)
@Composable
fun Preview7() {
    AdefaultTheme {
        MyImageTest2()
    }
}