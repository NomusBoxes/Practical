package com.example.practice48

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun btnUn(view: View){
        createNotificationChannel()
        val penIntent = PendingIntent.getBroadcast(this,1,
            Intent(this, MyReceiver::class.java),0)
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
            SystemClock.elapsedRealtime()+15000,
            AlarmManager.INTERVAL_FIFTEEN_MINUTES,
            penIntent)
    }

    fun btnEn(view: View) {
        val penIntent = PendingIntent.getBroadcast(this,1,
            Intent(this,MyReceiver::class.java),0)
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        if (penIntent != null) alarmManager.cancel(penIntent)
    }

    fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("TestNotify", "name",
                NotificationManager.IMPORTANCE_DEFAULT)
            channel.description = "discription"
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}

