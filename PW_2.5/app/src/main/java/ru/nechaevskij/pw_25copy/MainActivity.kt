package ru.nechaevskij.pw_25copy

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import ru.nechaevskij.pw_25copy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val radio_good = bind.good
        val radio_bad = bind.bad
        val pic = bind.mood
        radio_good.setOnClickListener {
            pic.setImageResource(R.drawable.good)
        }
        radio_bad.setOnClickListener {
            pic.setImageResource(R.drawable.sad)
        }
        val ok_but = findViewById<Button>(R.id.save)
        ok_but.setOnClickListener {
            val s: String = "Записано!\n" +
                    "Событие: ${bind.vevent.text}\n" +
                    "Дата: ${bind.vdata.text}\n" +
                    "Время: ${bind.time.text}\n" +
                    "Заметки: ${bind.post.text}"
            Toast.makeText(this, s, Toast.LENGTH_LONG).show()
        }
        val arr = arrayOf(0,1,2,3,4)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arr)
        val myImage: Drawable = resources.getDrawable(ResourcesCompat)
    }
}