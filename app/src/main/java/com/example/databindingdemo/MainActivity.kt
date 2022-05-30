package com.example.databindingdemo

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databindingdemo.databinding.MainActivityBinding
import com.example.databindingdemo.model.User
import com.example.databindingdemo.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        // Set user properties via DataBindingUtil
        val binding: MainActivityBinding = DataBindingUtil.setContentView(
            this, R.layout.main_activity
        )

        binding.user = User("John", "Doe", age = 23)
        // Set properties via layout inflation
//        val bindingInflate: MainActivityBinding = MainActivityBinding.inflate(layoutInflater)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.userViewModel = userViewModel
        binding.lifecycleOwner = this

        userViewModel.password?.observe(this) {
            binding.userName.text = it
        }

        binding.exampleText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(char: CharSequence?, start: Int, before: Int, count: Int) {
                userViewModel.setPassword(char.toString())
            }
        })
    }
}