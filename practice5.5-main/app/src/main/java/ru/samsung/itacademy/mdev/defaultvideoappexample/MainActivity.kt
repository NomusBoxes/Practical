package ru.samsung.itacademy.mdev.defaultvideoappexample

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.MediaController
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import ru.samsung.itacademy.mdev.defaultvideoappexample.databinding.ActivityMainBinding
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var videoFilePath = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    REQUEST_PERMISSION)
        }
        binding.button.setOnClickListener { openVideoIntent() }
    }

    private fun openVideoIntent() {
        val videoIntent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        if (videoIntent.resolveActivity(packageManager) != null) {
            var videoFile: File? = null
            videoFile = try {
                createVideoFile()
            } catch (e: IOException) {
                e.printStackTrace()
                return
            }
            val videoUri: Uri = FileProvider.getUriForFile(this, "$packageName.provider", videoFile)
            videoIntent.putExtra(MediaStore.EXTRA_OUTPUT, videoUri)
            startActivityForResult(videoIntent, REQUEST_VIDEO)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_VIDEO) {
            if (resultCode == Activity.RESULT_OK) {
                binding.video.setVideoURI(Uri.parse(videoFilePath))
                binding.video.start()
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "You cancelled the operation", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @Throws(IOException::class)
    private fun createVideoFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val imageFileName = "VIDEO_" + timeStamp + "_"
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_MOVIES)
        val video: File = File.createTempFile(imageFileName, ".mp4", storageDir)
        videoFilePath = video.absolutePath
        return video
    }

    companion object {
        const val REQUEST_VIDEO = 100
        const val REQUEST_PERMISSION = 200
    }
}