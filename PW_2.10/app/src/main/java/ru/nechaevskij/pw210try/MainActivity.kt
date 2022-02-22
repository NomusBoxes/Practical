package ru.nechaevskij.pw210try

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv: TextView = findViewById(R.id.textView)
        tv.text=findViewById(R.id.editTextTextPersonName)
        val drawable: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.ic_launcher_background, null)
    }
}