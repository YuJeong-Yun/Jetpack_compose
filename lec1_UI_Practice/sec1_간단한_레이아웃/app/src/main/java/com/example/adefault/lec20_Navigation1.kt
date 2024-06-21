package com.example.adefault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.adefault.ui.theme.AdefaultTheme

class lec20_Navigation1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdefaultTheme {
                MyNav()
            }
        }
    }
}

@Composable
fun MyScreen1(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "화면1", fontSize = 50.sp)
        Button(onClick = {
            navController.navigate("myScreen2")
        }) {
            Text(text = "2번 화면으로 가기", fontSize = 30.sp)
        }
    }
}

@Composable
fun MyScreen2(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "화면2", fontSize = 50.sp)
        Button(onClick = {
            navController.navigate("myScreen3")
        }) {
            Text(text = "3번 화면으로 가기", fontSize = 30.sp)
        }
    }
}

@Composable
fun MyScreen3(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "화면3", fontSize = 50.sp)
        Button(onClick = {
            navController.navigate("myScreen1")
        }) {
            Text(text = "1번 화면으로 가기", fontSize = 30.sp)
        }
    }
}

@Composable
fun MyNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "myScreen1") {
        composable("myScreen1") {
            MyScreen1(navController = navController)
        }
        composable("myScreen2") {
            MyScreen2(navController = navController)
        }
        composable("myScreen3") {
            MyScreen3(navController = navController)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    AdefaultTheme {
        MyNav()
    }
}