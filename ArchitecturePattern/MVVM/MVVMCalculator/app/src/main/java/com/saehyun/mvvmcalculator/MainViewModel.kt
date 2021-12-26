package com.saehyun.mvvmcalculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {
    val toastmessage: MutableLiveData<Int> = MutableLiveData()

    fun plus(mainData: MainData) {
        val sum: Int = mainData.num1 + mainData.num2
        toastmessage.value = sum
    }

}