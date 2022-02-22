package ru.nechaevskij.pw26try

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RandomNumberViewModel:ViewModel(){
    // Create a LiveData with a random number
    val currentRandomNumber:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    fun generateRnd(){
        currentRandomNumber.value = (0..50).random()
    }
}

class MainActivity : AppCompatActivity() {
    lateinit var viewModelRndNum: RandomNumberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider = ViewModelProvider(this)
        viewModelRndNum = provider.get(RandomNumberViewModel::class.java)

        observeViewModel()

        initView()
    }
    private fun observeViewModel() {
        viewModelRndNum.currentRandomNumber.observe(this, Observer {
            var text = findViewById<TextView>(R.id.rndText)
            var edText = findViewById<EditText>(R.id.rndNum)
            text.text = it.toString()
            edText.setText(it.toString())
        })
    }
    private fun initView() {
        val generate = findViewById<Button>(R.id.getRnd)
        generate.setOnClickListener {
            viewModelRndNum.generateRnd()
        }
    }
}