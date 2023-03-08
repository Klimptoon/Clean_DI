package com.example.myapplicationsdfsf.data.storage

import com.example.myapplicationsdfsf.data.storage.models.User
import com.example.myapplicationsdfsf.domain.models.SaveUserNameParam
import com.example.myapplicationsdfsf.domain.models.UserName

interface UserStorage {

    fun save(user: User) : Boolean
    fun get(): User

}