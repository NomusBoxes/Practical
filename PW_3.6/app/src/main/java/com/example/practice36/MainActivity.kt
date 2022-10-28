package com.example.practice36

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.practice36.databinding.ActivityMainBinding
import com.example.practice36.databinding.FragmentColorListBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    val viewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.fr1, ColorListFragment.newInstance()).commit()
        supportFragmentManager.beginTransaction().replace(R.id.fr2, ColoredFragment.newInstance()).commit()


    }
}