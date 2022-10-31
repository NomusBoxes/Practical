package com.example.preferencesscreenexample

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import com.example.preferencesscreenexample.databinding.SettingsActivityBinding

class SettingsActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {
    lateinit var binding: SettingsActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SettingsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        if(sharedPreferences.getBoolean("example_switch", false))
            setColor(sharedPreferences.getString("list", "")!!)
        sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        when (key) {
            "example_switch" -> {
                val test = sharedPreferences!!.getBoolean("example_switch", false)
                Toast.makeText(this, test.toString(), Toast.LENGTH_SHORT).show()
                if(!test)
                    binding.settings.setBackgroundColor(Color.WHITE)
                else {
                    val test2 = sharedPreferences!!.getString("list", "")
                    if(test2 != null){
                        setColor(test2)
                    }
                }
            }
            "list" ->{
                val test = sharedPreferences!!.getString("list", "")
                if(test != null){
                    setColor(test)
                }
            }
        }
    }

    private fun setColor(test: String){
            when(test){
                "1" -> binding.settings.setBackgroundColor(Color.RED)
                "2" -> binding.settings.setBackgroundColor(Color.GREEN)
                "3" -> binding.settings.setBackgroundColor(Color.BLUE)
            }
        }


    override fun onDestroy() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this)
    }
}