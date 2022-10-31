package com.example.practice48

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.work.*
import com.example.practice48.databinding.ActivityMainBinding
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var count:Int = 0
    lateinit var process1: OneTimeWorkRequest
    lateinit var process2: OneTimeWorkRequest
    lateinit var data: Data
    var flag = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    fun startProcessClick(view: View){
        if(flag) {
            data = Data.Builder().putInt("click", count).build()
            process1 = OneTimeWorkRequestBuilder<TextWorker>().setInputData(data).addTag("p1").build()
            process2 = OneTimeWorkRequestBuilder<LongWorker>().addTag("p2").build()
            WorkManager.getInstance(this)
                .beginWith(process1)
                .then(process2)
                .enqueue()
            flag = false
        }
        else return
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(process2.id)
            .observe(this, androidx.lifecycle.Observer {
                if(it.state== WorkInfo.State.SUCCEEDED)
                    flag = true
            })
    }


    fun clickerClick(view: View){
        count++
        binding.clicker.text = count.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            WorkManager.getInstance(this).cancelAllWorkByTag("p1")
            WorkManager.getInstance(this).cancelAllWorkByTag("p2")
            Log.d("test_worker","onDestroy")
        }
        catch (ex: Exception){}

    }

}

