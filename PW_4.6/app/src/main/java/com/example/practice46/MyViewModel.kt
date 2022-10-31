package com.example.practice46

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var count = MutableLiveData<Int>(0)

    fun onChange() {
        count.value = count.value?.plus(1)
    }
}