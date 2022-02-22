package ru.nechaevskij.bindeddatatemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ru.nechaevskij.bindeddatatemplate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
    }
}