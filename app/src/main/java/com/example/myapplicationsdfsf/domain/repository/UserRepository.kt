package com.example.myapplicationsdfsf.domain.repository

import com.example.myapplicationsdfsf.domain.models.SaveUserNameParam
import com.example.myapplicationsdfsf.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam : SaveUserNameParam) : Boolean

    fun getName(): UserName
}