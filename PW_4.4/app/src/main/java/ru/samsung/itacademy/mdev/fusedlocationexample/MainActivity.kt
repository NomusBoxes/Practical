package ru.samsung.itacademy.mdev.fusedlocationexample

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*

class MainActivity : AppCompatActivity() {
    private var fusedLocationClient: FusedLocationProviderClient? = null
    private var lastLocation: Location? = null
    private var textLocation: TextView? = null
    private var textAdress: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textLocation = findViewById<View>(R.id.textLocation) as TextView
        textAdress = findViewById<View>(R.id.textAdress) as TextView
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        val button: Button = findViewById(R.id.getLocation)
        button.setOnClickListener {
            permAndReq()
            getLocation()
        }
    }

    public override fun onStart() {
        super.onStart()
        permAndReq()
    }

    private fun permAndReq() {
        if (!checkPermissions()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                startLocationPermissionRequest()
            }
        }
    }

        private fun getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            showMessage("Необходимо дать доступ к геолокации на устройстве")
            return
        }
        fusedLocationClient?.lastLocation!!.addOnCompleteListener(this) { task ->
            if (task.isSuccessful && task.result != null) {
                lastLocation = task.result
                textLocation!!.text = "Latitude: " + (lastLocation)!!.latitude + "\nLongitude:" + (lastLocation)!!.longitude
                textAdress!!.text = getAddress((lastLocation)!!.latitude, (lastLocation)!!.longitude)
            }
            else {
                showMessage("Геолокация на устройстве отключена")
            }
        }
    }

    private fun showMessage(string: String) {
            Toast.makeText(this@MainActivity, string, Toast.LENGTH_LONG).show()
    }

    private fun checkPermissions(): Boolean {
        val permissionState = ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
        )
        return permissionState == PackageManager.PERMISSION_GRANTED
    }

    private fun startLocationPermissionRequest() {
        ActivityCompat.requestPermissions(
                this@MainActivity,
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                REQUEST_PERMISSIONS_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
            requestCode: Int, permissions: Array<String>,
            grantResults: IntArray
    ) {
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            when {
                grantResults.isEmpty() -> {}
                grantResults[0] == PackageManager.PERMISSION_GRANTED -> {
                    getLocation()
                }
                else -> {
                    showMessage("Вы отклонили запрос на доступ к геолокации")
                }
            }
        }
    }


    private fun getAddress(lat: Double, lng: Double): String {
        val geocoder = Geocoder(this, Locale.getDefault())
        val list = geocoder.getFromLocation(lat, lng, 1)
        return list[0].getAddressLine(0)
    }

    companion object {
        private val REQUEST_PERMISSIONS_REQUEST_CODE = 34
    }
}

