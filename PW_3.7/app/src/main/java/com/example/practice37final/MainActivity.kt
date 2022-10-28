package com.example.practice37final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice37final.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        binding.root.setOnClickListener{
            TestCheckboxDialog().show(supportFragmentManager, "tag")
        }
    }
}