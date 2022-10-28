package com.example.practice37final

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class TestCheckboxDialog: DialogFragment(){
    private val langs = R.array.checkbox
    private val checked= booleanArrayOf(true, true)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            AlertDialog.Builder(it)
                .setMultiChoiceItems(langs, checked){ _, which, isChecked ->
                    checked[which] = isChecked
                }
                .setPositiveButton("Ok"
                ) { _, _ ->
                    TestTimePickerDialog(checked[0], checked[1]).show(parentFragmentManager, "tag2")
                }
                .create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
