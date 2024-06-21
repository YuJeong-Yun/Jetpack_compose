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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.adefault.ui.theme.AdefaultTheme
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class le23_Retrofit2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdefaultTheme {
                InsertInputData()
            }
        }
    }
}

@Composable
fun InsertInputData() {
    // 입력하는 숫자
    var inputNumber by remember { mutableStateOf("") }

    // 받아온 데이터 모델
    var post by remember { mutableStateOf<Post2?>(null) }

    // API 통신하는 부분
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = inputNumber, onValueChange = { inputNumber = it },
            label = { Text(text = "값을 입력해주세요.") }
        )

        Button(onClick = {
            val number = inputNumber.toIntOrNull()
            if (number != null) {
                coroutineScope.launch {
                    post = getPostData(number)
                }
            }
        }) {
            Text(text = "데이터 받아오기")
        }
        post?.let {
            Text(text = "UserId : " + it.userId)
            Text(text = "ID : " + it.id)
            Text(text = "Title : " + it.title)
            Text(text = "Body : " + it.body)
        }
    }
}

private suspend fun getPostData(number: Int): Post2? {
    val retrofitInstance = RetrofitInstance2.getInstance().create(MyApi2::class.java)
    val response = retrofitInstance.getPostNumber(number)

    return response.body()
}


data class Post2(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

object RetrofitInstance2 {
    val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val client = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getInstance(): Retrofit {
        return client
    }
}

interface MyApi2 {
    @GET("posts/{number}")
    suspend fun getPostNumber(
        @Path("number") number: Int
    ): Response<Post2>
}