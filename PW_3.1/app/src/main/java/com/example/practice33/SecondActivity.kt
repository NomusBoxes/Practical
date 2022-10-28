package com.example.practice33

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_activity.*

class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        val from = intent.getStringExtra("from")!!.toInt()
        val to = intent.getStringExtra("to")!!.toInt()
        var set: MutableSet<Int> = mutableSetOf()
        for(l in from .. to)
            set.add(l)
        var setRand = set.random()
        result.text = "Ваше число $setRand?"

        da.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        ne.setOnClickListener {
            set.remove(setRand)
            if (set.isEmpty())
                result.text = "Больше в диапазоне чисел нет("
            else{
                setRand = set.random()
                result.text = "Ваше число $setRand?"
            }
        }

    }


}