package com.example.adefault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adefault.ui.theme.AdefaultTheme

class lec6_TextFiled_OutlinedTextField : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdefaultTheme {
                MyTextField3()
            }
        }
    }
}

@Composable
fun MyTextField1() {
    var textState by remember { mutableStateOf("Hello") }

    TextField(
        value = textState,
        onValueChange = {
            textState = it
        },
        label = {
            Text(text = "입력하는 공간")
        },
        modifier = Modifier.padding(30.dp)
    )
}

@Composable
fun MyTextField2() {
    var textState by remember { mutableStateOf("Hello") }

    OutlinedTextField(
        value = textState,
        onValueChange = {
            textState = it
        },
        label = {
            Text(text = "입력하는 공간")
        },
        modifier = Modifier.padding(30.dp)
    )
}

// TextField 부분에 입력하고 버튼을 클릭하면
// 밑에 Text부분에 입력한 값이 나오도록 하는 부분
@Composable
fun MyTextField3() {
    // 입력한 부분
    var textState by remember { mutableStateOf("") }

    // 결과값 부분
    var enteredText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, // 세로로 중앙정렬
        horizontalAlignment = Alignment.CenterHorizontally // 가로로 중앙정렬
    ) {
        TextField(
            value = textState,
            onValueChange = {
                textState = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                enteredText = textState
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "입력하기")
        }
        Text(text = "결과값 텍스트 : ${enteredText}")
    }


}


@Preview(showBackground = true)
@Composable
fun Preview6() {
    AdefaultTheme {
        MyTextField3()
    }
}