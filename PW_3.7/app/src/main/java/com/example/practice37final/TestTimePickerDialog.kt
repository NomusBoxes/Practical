package com.example.practice37final

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class TestTimePickerDialog(private val stars: Boolean, private val sun: Boolean): DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance();
        val curHour = c.get(Calendar.HOUR_OF_DAY);
        val curMinute = c.get(Calendar.MINUTE);
        return TimePickerDialog(activity, { _, hour, minute ->
            val frag = parentFragmentManager.findFragmentById(R.id.frag) as TestFragment
            frag.setState(hour, minute, sun, stars)
        }, curHour, curMinute, false)
    }
}