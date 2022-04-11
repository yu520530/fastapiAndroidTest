package com.example.fastapitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private val url = "https://39cd-2001-b011-b800-bd53-6d06-ab4f-2fbf-f471.ngrok.io/"
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
        btn_search_page.setOnClickListener {
            // 切換頁面
            val search_page = Intent(this,MedicineSearchActivity::class.java)
            startActivity(search_page)
        }
    }
}