package ru.nechaevskij.pw27try

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ru.nechaevskij.pw27try.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        bind.show.setOnClickListener {
            bind.solution.setText("EditText: " + bind.editText.text.toString() + "\n")
            if (bind.checkBox.isChecked)
                bind.solution.setText(bind.solution.text.toString() + "CheckBox: ON" + "\n")
            else
                bind.solution.setText(bind.solution.text.toString() + "CheckBox: OFF" + "\n")
            if (bind.toggleButton.isChecked)
                bind.solution.setText(bind.solution.text.toString() + "ToggleButton: ON" + "\n")
            else
                bind.solution.setText(bind.solution.text.toString() + "ToggleButton: OFF" + "\n")
            if (bind.radioButton.isChecked)
                bind.solution.setText(bind.solution.text.toString() + "RadioGroup: RadioButton 1")
            if (bind.radioButton2.isChecked)
                bind.solution.setText(bind.solution.text.toString() + "RadioGroup: RadioButton 2")

        }
    }


}