package com.example.myapplicationsdfsf.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myapplicationsdfsf.R
import com.example.myapplicationsdfsf.data.UserRepositoryImplementation
import com.example.myapplicationsdfsf.domain.models.SaveUserNameParam
import com.example.myapplicationsdfsf.domain.models.UserName
import com.example.myapplicationsdfsf.domain.usecase.GetUserNameUseCase
import com.example.myapplicationsdfsf.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImplementation(context = applicationContext) }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataText = findViewById<TextView>(R.id.data_text)
        val dataEditText = findViewById<EditText>(R.id.save_data_edit_text)
        val sendButton = findViewById<Button>(R.id.save_data_button)
        val receiveButton = findViewById<Button>(R.id.get_data_button)




        receiveButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            dataText.text = "${userName.firstName}  ${userName.lastName}"

        }
        sendButton.setOnClickListener {
            val text = dataEditText.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(params)
            dataText.text = "Save result = $result"
        }
    }
}