package com.example.app2

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerReceiver(Student1(), IntentFilter("com.example.app2.POST").apply { priority = 6 })
        registerReceiver(Student3434(), IntentFilter("com.example.app2.POST").apply { priority = 1 })
        registerReceiver(Student23(), IntentFilter("com.example.app2.POST").apply { priority = 4 })
        registerReceiver(Student35(), IntentFilter("com.example.app2.POST").apply { priority = 2 })
        registerReceiver(Student11(), IntentFilter("com.example.app2.POST").apply { priority = 5 })
        registerReceiver(Student27(), IntentFilter("com.example.app2.POST").apply { priority = 3 })
    }
}