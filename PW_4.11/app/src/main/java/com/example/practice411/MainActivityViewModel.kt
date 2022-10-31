package com.example.practice411

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    val str1: MutableLiveData<String> = MutableLiveData("")
    val str2: MutableLiveData<String> = MutableLiveData("")
    val str3: MutableLiveData<String> = MutableLiveData("")
}