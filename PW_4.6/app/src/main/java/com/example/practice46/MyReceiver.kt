package com.example.practice46

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.example.practice46.databinding.ActivityMainBinding

interface MyBroadcastListener {
    fun change()
}

class MyReceiver : BroadcastReceiver() {
    private var listener: MyBroadcastListener? = null

    override fun onReceive(context: Context, intent: Intent) {
        listener = context as MyBroadcastListener
        listener!!.change()

    }
}