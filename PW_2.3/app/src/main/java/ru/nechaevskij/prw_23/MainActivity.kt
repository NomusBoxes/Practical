package ru.nechaevskij.prw_23

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.util.*

fun msg(s: String, c: Context){
    Toast.makeText(c, s, Toast.LENGTH_SHORT).show()
}
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}