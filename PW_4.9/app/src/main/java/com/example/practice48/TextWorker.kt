package com.example.practice48

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class TextWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams){
    override fun doWork(): Result {
        Log.d("test_worker","text_worker_start")

        val dataFromMA = inputData.getInt("click",0)
        val al: String = "abcdefghijklmnopqrstuvwxyz"
        val c: String = "friend"
        var s: String = ""

        for(letter1 in al)
            for (letter2 in al)
                for (letter3 in al)
                    for (letter4 in al)
                        for (letter5 in al)
                            for (letter6 in al){
                                s = letter1.toString() + letter2.toString() + letter3.toString() +
                                        letter4.toString() + letter5.toString() + letter6.toString()
                                if(s==c){
                                    Log.d("test_worker","text_worker_stop")
                                    val d: Data = Data.Builder().putString("data_is",s)
                                        .putInt("click", dataFromMA).build()
                                    return Result.success(d)
                                }
                            }
        Log.d("test_worker","failure")
        return Result.failure()
    }
}
