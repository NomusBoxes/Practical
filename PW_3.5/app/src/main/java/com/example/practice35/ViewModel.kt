package com.example.practice35

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel(){
    val fragmentFlag : MutableLiveData<Boolean> = MutableLiveData<Boolean>(true)

    fun changeFlag() {
        fragmentFlag.value = !fragmentFlag.value!!
    }
}