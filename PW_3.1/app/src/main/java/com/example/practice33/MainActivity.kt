package com.example.practice33

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getRes.setOnClickListener {
            val i = Intent(this, SecondActivity::class.java).apply {
                putExtra("from",from.text.toString())
                putExtra("to",to.text.toString())
            }
            startActivity(i)

        }
    }




}