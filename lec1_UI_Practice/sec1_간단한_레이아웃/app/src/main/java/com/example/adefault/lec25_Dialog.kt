package com.example.adefault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.adefault.ui.theme.AdefaultTheme

class lec25_Dialog : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdefaultTheme {
                MyDialog()
            }
        }
    }
}

@Composable
fun MyDialog() {
    var dialogFlag by remember { mutableStateOf(false) }
    var inputText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            dialogFlag = true
        }) {
            Text(text = "나와라 Dialog")
        }

        if (dialogFlag) {
            AlertDialog(onDismissRequest = { /*TODO*/ },
                title = { Text(text = "Dialog Title") },
                text = {
                    TextField(value = inputText, onValueChange = {
                        inputText = it
                    })
                },
                confirmButton = {
                    Button(
                        onClick = { dialogFlag = false },
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color.Blue
                        )
                    ) {
                        Text(text = "OK")
                    }
                }, // 확인 버튼
                dismissButton = {
                    Button(
                        onClick = { dialogFlag = false },
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color.Red
                        )
                    ) {
                        Text(text = "NO")
                    }
                } // 취소 버튼
            )
            //
        }

        if (inputText.isNotEmpty()) {
            Text(
                text = "입력된 텍스트 : ${inputText}",
                fontSize = 40.sp,
                lineHeight = 50.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview25() {
    AdefaultTheme {
        MyDialog()
    }
}