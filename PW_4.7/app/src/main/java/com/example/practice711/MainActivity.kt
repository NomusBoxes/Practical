package com.example.practice711

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

     fun sendBr(view: View) {
        sendOrderedBroadcast(
            Intent("com.example.app2.POST"),null,
            MyReceiver(),null,0,"NewPost",
            Bundle().apply{putString("studentList", "Список присутствующих:\n")})
    }

}