package com.example.databindingdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.databindingdemo.model.Popularity

class UserViewModel : ViewModel() {
    private val _name = MutableLiveData("John")
    private val _lastName = MutableLiveData("Doe")
    private val _likes =  MutableLiveData(0)

    val name: LiveData<String> = _name
    val lastName: LiveData<String> = _lastName
    val likes: LiveData<Int> = _likes

    val popularity: LiveData<Popularity> = Transformations.map(_likes) {
        when {
            it > 9 -> Popularity.STAR
            it > 4 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }
    }

    fun onLike() {
        _likes.value = (_likes.value ?: 0) + 1
    }
}
