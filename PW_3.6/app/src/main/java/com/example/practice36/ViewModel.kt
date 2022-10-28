package com.example.practice36

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel(){
    val list : MutableLiveData<ArrayList<ColorInfo>> by lazy {
        MutableLiveData<ArrayList<ColorInfo>>()
    }

    val colorId : MutableLiveData<ColorInfo> by lazy {
        MutableLiveData<ColorInfo>()
    }


}