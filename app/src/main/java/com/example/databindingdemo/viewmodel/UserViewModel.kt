package com.example.databindingdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {

    var password: MutableLiveData<String>? = null

    fun setPassword(password: String) {
        this.password?.value = password
    }
}