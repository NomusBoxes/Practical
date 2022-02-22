package ru.nechaevskij.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pic = findViewById<ImageView>(R.id.answer)
        pic.visibility = View.INVISIBLE
        val b = findViewById<Button>(R.id.inspect)


        /*b.setOnClickListener{
            Toast.makeText(this, km, Toast.LENGTH_SHORT).show()
            Log.d("ff", km)
        }*/
        b.setOnClickListener {
            val res = findViewById<TextView>(R.id.rezult)
            val texts = arrayOf(
                findViewById<EditText>(R.id.km),
                findViewById<EditText>(R.id.m),
                findViewById<EditText>(R.id.dm),
                findViewById<EditText>(R.id.sm),
                findViewById<EditText>(R.id.mm)
            )
            var numbs = mutableListOf<Float>()
            var empty = true
            for (num in texts){
                if (num.text.toString() != "") {
                    numbs.add(num.text.toString().toFloat())
                    empty = false
                }
                else {
                    empty = true
                    break
                }
            }
            if(empty){
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
            else {
                if (numbs[0] * 1000 != numbs[1] ||
                    numbs[1] * 10 != numbs[2] ||
                    numbs[2] * 10 != numbs[3] ||
                    numbs[3] * 10 != numbs[4]
                ) {
                    res.setTextColor(getColor(R.color.red))
                    res.text = getString(R.string.bad)
                    pic.visibility = View.VISIBLE
                    pic.setImageResource(R.drawable.bad)
                } else {
                    res.setTextColor(getColor(R.color.blue))
                    res.text = getString(R.string.good)
                    pic.visibility = View.VISIBLE
                    pic.setImageResource(R.drawable.cool)
                }
            }
        }
        pic.alpha = 1f
        pic.setOnClickListener {
            if (pic.alpha > 0.1f) pic.alpha -= 0.1f
            else pic.alpha = 1f
        }


    }


}
