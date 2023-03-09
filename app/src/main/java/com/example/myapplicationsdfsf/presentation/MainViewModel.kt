package com.example.myapplicationsdfsf.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplicationsdfsf.data.repository.UserRepositoryImplementation
import com.example.myapplicationsdfsf.data.storage.sharedrefs.SharedPrefUserStorage
import com.example.myapplicationsdfsf.domain.models.SaveUserNameParam
import com.example.myapplicationsdfsf.domain.models.UserName
import com.example.myapplicationsdfsf.domain.usecase.GetUserNameUseCase
import com.example.myapplicationsdfsf.domain.usecase.SaveUserNameUseCase

class MainViewModel(private val saveUserNameUseCase : SaveUserNameUseCase,
                    private val getUserNameUseCase : GetUserNameUseCase
                    ) : ViewModel() {

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive : LiveData<String> = resultLiveMutable
    

    init {
        Log.e("AAA", "VM CREATED")
    }

    override fun onCleared() {
        Log.e("AAA", "VM CREATED")
        super.onCleared()
    }

    fun save(text : String) {
        val params = SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(params)
        resultLiveMutable.value = "Save result = $resultData"
    }

    fun load()  {
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveMutable.value =  "${userName.firstName}  ${userName.lastName}"
    }

}