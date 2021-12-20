package com.example.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveData: ViewModel() {
    val liveData = MutableLiveData<String>("Hello World!!")

    fun dataChange(text : String){
        liveData.value = text
    }

}