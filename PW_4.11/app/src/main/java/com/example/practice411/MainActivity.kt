package com.example.practice411

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.practice411.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var viewBinding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    private lateinit var sensorManager: SensorManager
    var lSensor: Sensor? = null
    var rSensor:Sensor? = null
    var aSensor:Sensor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initVm()
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

    }

    private fun initVm() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.str1.observe(this){
            if(viewBinding.first.isChecked)
            viewBinding.text.text = it
        }
        viewModel.str2.observe(this){
            if(viewBinding.second.isChecked)
                viewBinding.text.text = it
        }
        viewModel.str3.observe(this){
            if(viewBinding.third.isChecked)
                viewBinding.text.text = it
        }
    }

    override fun onResume() {
        super.onResume()
        lSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        if(lSensor !=null)
            sensorManager.registerListener(this,lSensor,SensorManager.SENSOR_DELAY_GAME)

        rSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
        if(rSensor !=null)
            sensorManager.registerListener(this,rSensor,SensorManager.SENSOR_DELAY_GAME)

        aSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        if(aSensor !=null)
            sensorManager.registerListener(this,aSensor,SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    private fun toast(text: String){
        Toast.makeText(this, text ,Toast.LENGTH_LONG).show()
    }

    fun onRadioButtonClicked(view: View) {

            when (view.id) {
                R.id.first -> viewBinding.text.text = viewModel.str1.value
                R.id.second -> viewBinding.text.text = viewModel.str2.value
                R.id.third -> viewBinding.text.text = viewModel.str3.value
            }
        }

    override fun onSensorChanged(event: SensorEvent?) {
        var h = 0f
        var t = 0f
        if (lSensor == null) viewModel.str1.value = getString(R.string.sensorAbsentL)
        else if (event!!.sensor.type == lSensor!!.type)
            viewModel.str1.value = "Освещённость: " + event.values[0]

        if (rSensor == null) viewModel.str2.value = getString(R.string.sensorAbsentR)
        else if (event!!.sensor.type == rSensor!!.type)
            viewModel.str2.value = "Проекция вектора по осям:" +
                    "\nOX" + event.values[0]+
                    "\nOY"+ event.values[1] +
                    "\nOZ"+ event.values[2] +
                    "\nСкалярная мера угла поворота:" + event.values[3]

        if (aSensor == null) viewModel.str3.value = getString(R.string.sensorAbsentA)
        else if (event!!.sensor.type == lSensor!!.type)
            viewModel.str3.value = "Динамическое ускорение по осям:" +
                    "\nOX" + event.values[0]+
                    "\nOY"+ event.values[1] +
                    "\nOZ"+ event.values[2]
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}
}