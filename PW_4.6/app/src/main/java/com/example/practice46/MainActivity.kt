package com.example.practice46

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.practice46.databinding.ActivityMainBinding
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity(), MyBroadcastListener {
    val receiver=MyReceiver()
    val receiver2 = MyReceiver2()
    lateinit var ViewModel: MyViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()

        registerReceiver(receiver, IntentFilter("android.intent.action.TIME_TICK"))
        registerReceiver(receiver2, IntentFilter("android.intent.action.BATTERY_LOW"))

        binding.btn.setOnClickListener {
            try {
                unregisterReceiver(receiver)
                Toast.makeText(this, R.string.toast_text, Toast.LENGTH_SHORT).show()
            } catch (e: IllegalArgumentException) {
                Toast.makeText(this, "Broadcast уже отключён", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            unregisterReceiver(receiver)
        } catch (e: IllegalArgumentException) { }
        unregisterReceiver(receiver2)
    }

    fun initViewModel() {
        ViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        ViewModel.count.observe(this, {
            if(it!=0)
            binding.print.text = "время созерцания " + it.toString() + " мин."
        })

    }

    override fun change() {
        ViewModel.onChange()
    }
}