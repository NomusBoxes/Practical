package ru.samsung.itacademy.mdev.simplereceiver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import ru.samsung.itacademy.mdev.simplereceiver.databinding.ActivityReceivingBinding

class ReceivingActivity : AppCompatActivity() {
    lateinit var binding: ActivityReceivingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceivingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(intent?.action == Intent.ACTION_SEND)
            binding.editText.setText(intent.getStringExtra(Intent.EXTRA_TEXT))
    }
}