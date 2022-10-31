package com.example.practice48

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.practice48.databinding.ActivityExerciseBinding
import kotlin.random.Random

class Exercise : AppCompatActivity() {
    lateinit var binding: ActivityExerciseBinding
    var num: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pictures = intArrayOf(R.drawable.eye1, R.drawable.eye2,
            R.drawable.eye3, R.drawable.eye4, R.drawable.eye5,R.drawable.eye6)
        val exText = resources.getStringArray(R.array.exercises)
        num = (0..5).random()
        binding.pict.setImageResource(pictures[num])
        binding.exercText.text = exText[num]
    }

    fun onOk(view: View){
        finish()
    }
}