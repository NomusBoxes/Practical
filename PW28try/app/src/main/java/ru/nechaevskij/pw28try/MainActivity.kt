package ru.nechaevskij.pw28try

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.databinding.DataBindingUtil
import ru.nechaevskij.pw28try.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bind: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val solve_options: Array<String> = resources.getStringArray(R.array.solveOptions)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, solve_options)
        bind.spinner.adapter = adapter
        bind.getSolution.setOnClickListener {
            if (
                bind.sideA.text.toString()==""||
                bind.sideB.text.toString()==""||
                bind.sideC.text.toString()==""
               )
                    bind.solution.text = "Ошибка ввода!"
            else{
                when (bind.spinner.selectedItem) {
                    solve_options[0] ->
                        bind.solution.text = (bind.sideA.text.toString().toInt()*4+
                                bind.sideB.text.toString().toInt()*4+
                                bind.sideC.text.toString().toInt()*4).toString()
                    solve_options[1] ->
                        bind.solution.text = (2*
                                (bind.sideA.text.toString().toInt()*bind.sideB.text.toString().toInt()+
                                        bind.sideA.text.toString().toInt()*bind.sideC.text.toString().toInt()+
                                        bind.sideB.text.toString().toInt()*bind.sideC.text.toString().toInt())).toString()
                    solve_options[2] ->
                        bind.solution.text = (bind.sideA.text.toString().toInt()*
                                bind.sideB.text.toString().toInt()*
                                bind.sideC.text.toString().toInt()).toString()

                }



                /*if(bind.spinner!=null)
                {
                    val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, solve_options)
                    bind.spinner.adapter = adapter
                    bind.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: AdapterView<*>,
                            view: View,
                            position: Int,
                            id: Long
                        ) {
                            TODO("Not yet implemented")
                        }
                    }

                }*/
            }
        }
    }
}