package com.example.myapplicationsdfsf.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myapplicationsdfsf.R
import com.example.myapplicationsdfsf.data.repository.UserRepositoryImplementation
import com.example.myapplicationsdfsf.data.storage.sharedrefs.SharedPrefUserStorage
import com.example.myapplicationsdfsf.databinding.ActivityMainBinding
import com.example.myapplicationsdfsf.domain.models.SaveUserNameParam
import com.example.myapplicationsdfsf.domain.models.UserName
import com.example.myapplicationsdfsf.domain.usecase.GetUserNameUseCase
import com.example.myapplicationsdfsf.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private val userRepository by lazy {UserRepositoryImplementation(userStorage = SharedPrefUserStorage(context = applicationContext))}
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository) }
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.getDataButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            binding.dataText.text = "${userName.firstName}  ${userName.lastName}"

        }
        binding.saveDataButton.setOnClickListener {
            val text = binding.saveDataEditText.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(params)
            binding.dataText.text = "Save result = $result"
        }
    }
}