package com.example.practice51final

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.practice51final.databinding.ActivityMainBinding
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    private val filename = "file.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.read.setOnClickListener(this)
        binding.write.setOnClickListener(this)
    }

    fun printMessage(m: String?) {
        Toast.makeText(this, m, Toast.LENGTH_LONG).show()
    }

    override fun onClick(view: View) {
        val b: Button = view as Button
        val b_text: String = b.getText().toString()
        when (b_text.lowercase(Locale.getDefault())) {
            "write" -> {
                writeData()
            }
            "read" -> {
                readData()
            }
        }
    }

    private fun writeData() {
        try {
            val fos: FileOutputStream = openFileOutput(filename, Context.MODE_APPEND)
            val data = binding.input.text.toString()
            fos.write(data.toByteArray())
            fos.flush()
            fos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        binding.input.setText("")
        printMessage("writing to file " + filename + "completed...")
    }

    private fun readData() {
        try {
            val fin: FileInputStream = openFileInput(filename)
            var a: Char
            val temp = StringBuilder()
            while (fin.read().also { a = it.toChar() } != -1) {
                temp.append(a)

            }

            binding.content.text = temp.toString()
            fin.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        printMessage("reading to file $filename completed..")
    }
}