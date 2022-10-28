package com.example.practice35

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.practice35.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ViewModel
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val provider = ViewModelProvider(this)
        viewModel = provider.get(ViewModel::class.java)

        viewModel.fragmentFlag.observe(this, {
            if(it){
                supportFragmentManager.beginTransaction().replace(R.id.fragment1, RedFragment.newInstance()).commit()
                supportFragmentManager.beginTransaction().replace(R.id.fragment2, BlueFragment.newInstance()).commit()
            }
            else{
                supportFragmentManager.beginTransaction().replace(R.id.fragment2, RedFragment.newInstance()).commit()
                supportFragmentManager.beginTransaction().replace(R.id.fragment1, BlueFragment.newInstance()).commit()
            }
        })

        binding.caption.setOnClickListener {
            viewModel.changeFlag()
        }

    }
}