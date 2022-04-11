package com.example.fastapitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_medicine_search.*
import okhttp3.*
import java.io.IOException


class MedicineSearchActivity : AppCompatActivity() {
    private val url = "https://39cd-2001-b011-b800-bd53-6d06-ab4f-2fbf-f471.ngrok.io/search"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicine_search)
        btn_search.setOnClickListener {
            val client = OkHttpClient.Builder().build()
            val request = Request.Builder().url(url+"/"+ed_search.text.toString()).get().build()
            val call = client.newCall(request)
            call.enqueue(object :Callback{
                override fun onFailure(call: Call, e: IOException) {
                   Log.d("searchh","error")
                }

                override fun onResponse(call: Call, response: Response) {
                    val result = response.body?.string()
                    tv_result.text = result
                }

            })
        }
    }
}