package com.example.databindingdemo.model

data class User(val firstName: String, val lastName: String, val age: Int)

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}
