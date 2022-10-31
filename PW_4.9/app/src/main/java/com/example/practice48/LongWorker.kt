package com.example.practice48

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters


class LongWorker(appContext: Context, params: WorkerParameters) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        Log.d("test_worker","long_worker_start")
        val data1 = inputData.getString("data_is")
        val data2 = inputData.getInt("click", 1)
        var p: Long = 0
        Log.d("test_worker","data: $data1 $data2")
        for (i in 1..data1!!.length*10000)
            for(j in 1..data2)
                p += i%j
        Log.d("test_worker","long_worker_stop with $p")
        return Result.success()
    }
}