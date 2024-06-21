package com.example.adefault

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.adefault.ui.theme.AdefaultTheme
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

// https://jsonplaceholder.typicode.com/posts/1

class lec22_Retrofit1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdefaultTheme {

                val coroutineScope = rememberCoroutineScope()
                val retrofitInstance = RetrofitInstance.getInstance().create(MyApi::class.java)
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = {
                        coroutineScope.launch {
                            val response = retrofitInstance.getPost1()
                            Log.d("MainActivity", response.body().toString())
                        }
                    }) {
                        Text(text = "Call api")
                    }
                }
            }

        }
    }
}

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

object RetrofitInstance {
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

interface MyApi {
    @GET("posts/1")
    suspend fun getPost1(): Response<Post>
}