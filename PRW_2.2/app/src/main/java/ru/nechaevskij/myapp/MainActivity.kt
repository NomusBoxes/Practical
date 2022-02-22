package ru.nechaevskij.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private val NCREATE = "Activity CREATED"
    private val NSTART = "Activity STARTED"
    private val NRESUME = "Activity RESUME"
    private val NPAUSE = "Activity PAUSED"
    private val NSTOP = "Activity STOPPED"
    private val NRESTART = "Activity RESTARTED"
    private val NDESTROY = "Activity DESTROYED"

    /*private fun msg(s: String, g: Gravity){
        var t = Toast.makeText(this, s, Toast.LENGTH_SHORT)
        t.setGravity(g, 0, 0)
        t.show()
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        Toast.makeText(this, NCREATE, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        val t = Toast.makeText(this, NSTART, Toast.LENGTH_SHORT)
        t.setGravity(Gravity.START, 0, 0)
        t.show()
    }

    override fun onResume() {
        super.onResume()
        var t = Toast.makeText(this, NRESUME, Toast.LENGTH_SHORT)
        t.setGravity(Gravity.TOP, 0, 0)
        t.show()
    }

    override fun onPause() {
        super.onPause()
        var t = Toast.makeText(this, NPAUSE, Toast.LENGTH_SHORT)
        t.setGravity(Gravity.END, 0, 0)
        t.show()
    }

    override fun onStop() {
        super.onStop()
        var t = Toast.makeText(this, NSTOP, Toast.LENGTH_SHORT)
        t.setGravity(Gravity.CENTER, 0, 0)
        t.show()
    }

    override fun onRestart() {
        super.onRestart()
        var t = Toast.makeText(this, NRESTART, Toast.LENGTH_SHORT)
        t.setGravity(Gravity.FILL_HORIZONTAL, 0, 0)
        t.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        var t = Toast.makeText(this, NDESTROY, Toast.LENGTH_SHORT)
        t.setGravity(Gravity.FILL, 0, 0)
        t.show()
    }

}
