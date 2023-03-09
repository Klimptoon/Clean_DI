package com.example.myapplicationsdfsf.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationsdfsf.data.repository.UserRepositoryImplementation
import com.example.myapplicationsdfsf.data.storage.sharedrefs.SharedPrefUserStorage
import com.example.myapplicationsdfsf.domain.usecase.GetUserNameUseCase
import com.example.myapplicationsdfsf.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context : Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImplementation(userStorage = SharedPrefUserStorage(context = context)) }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel( saveUserNameUseCase, getUserNameUseCase) as T
    }
}