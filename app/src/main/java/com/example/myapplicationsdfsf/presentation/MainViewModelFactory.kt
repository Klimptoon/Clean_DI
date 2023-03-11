package com.example.myapplicationsdfsf.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationsdfsf.data.repository.UserRepositoryImplementation
import com.example.myapplicationsdfsf.data.storage.sharedrefs.SharedPrefUserStorage
import com.example.myapplicationsdfsf.domain.usecase.GetUserNameUseCase
import com.example.myapplicationsdfsf.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(
    val getUserNameUseCase: GetUserNameUseCase,
    val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(saveUserNameUseCase, getUserNameUseCase) as T
    }
}