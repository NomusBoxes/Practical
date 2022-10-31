package com.example.practice410

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import com.example.practice410.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    //Датчики окружающей среды
    val ocrSred = arrayOf(Sensor.TYPE_MAGNETIC_FIELD, Sensor.TYPE_LIGHT, Sensor.TYPE_PRESSURE,
        Sensor.TYPE_RELATIVE_HUMIDITY, Sensor.TYPE_AMBIENT_TEMPERATURE)
    //Датчики положения устройства
    @RequiresApi(Build.VERSION_CODES.N)
    val polozhUstr = arrayOf(Sensor.TYPE_ACCELEROMETER,  Sensor.TYPE_GYROSCOPE,  Sensor.TYPE_PROXIMITY,
        Sensor.TYPE_GRAVITY, Sensor.TYPE_LINEAR_ACCELERATION,Sensor.TYPE_ROTATION_VECTOR,
        Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR,Sensor.TYPE_STEP_COUNTER, Sensor.TYPE_MOTION_DETECT)
    //Датчики состояния человека
    @RequiresApi(Build.VERSION_CODES.N)
    val sostUstr = arrayOf(Sensor.TYPE_HEART_BEAT, Sensor.TYPE_HEART_RATE)
    lateinit var viewBinding: ActivityMainBinding
    private lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setSpinner()
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

    }

    private fun setSpinner() {
        ArrayAdapter.createFromResource(this, R.array.type_sensors, android.R.layout.simple_spinner_item)
            .also{adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            viewBinding.spinner.adapter = adapter
            viewBinding.spinner.onItemSelectedListener = this
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
        var str = ""
        when(pos){
            0 -> for (i in ocrSred){
                str += sensorManager.getDefaultSensor(i)?.name ?: ""
                str += "\n"}
            1 -> for (i in polozhUstr){
                str += sensorManager.getDefaultSensor(i)?.name ?: ""
                str += "\n"}
            2 -> for (i in sostUstr){
                str += sensorManager.getDefaultSensor(i)?.name  ?: ""
                str += "\n"}
        }
        viewBinding.text.text = str
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}