package com.example.app2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


//Сделал несколько классов, как говорилось в задании, хотя, очевидно, можно было один сделать
class Student1 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val res = getResultExtras(true)
        var str = res.getString("studentList")
        str += "Student1\n"
        res.putString("studentList",str)
        setResult(++resultCode, resultData, res)
    }
}

class Student3434 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val res = getResultExtras(true)
        var str = res.getString("studentList")
        str += "Student3434\n"
        res.putString("studentList",str)
        setResult(++resultCode, resultData, res)
    }
}

class Student23 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val res = getResultExtras(true)
        var str = res.getString("studentList")
        str += "Student23\n"
        res.putString("studentList",str)
        setResult(++resultCode, resultData, res)
    }
}

class Student35 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val res = getResultExtras(true)
        var str = res.getString("studentList")
        str += "Student35\n"
        res.putString("studentList",str)
        setResult(++resultCode, resultData, res)
    }
}

class Student11 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val res = getResultExtras(true)
        var str = res.getString("studentList")
        str += "Student11\n"
        res.putString("studentList",str)
        setResult(++resultCode, resultData, res)
    }
}

class Student27 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val res = getResultExtras(true)
        var str = res.getString("studentList")
        str += "Student27\n"
        res.putString("studentList",str)
        setResult(++resultCode, resultData, res)
    }
}