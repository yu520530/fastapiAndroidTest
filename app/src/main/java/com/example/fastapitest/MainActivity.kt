package com.example.fastapitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private val url = "https://cb67-2001-b011-b800-bc8c-d478-4999-d69-ae55.ngrok.io/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = "123"
        val client = OkHttpClient.Builder().build()
        val request = Request.Builder().url(url).get().build()
        val call = client.newCall(request)
        btn_get.setOnClickListener {
            call.enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                    Log.d("apii", "error")
                }

                override fun onResponse(call: Call, response: Response) {
                    response.body?.string()?.let { it1 -> Log.d("apii", it1) }
                }

            })

        }
    }
}