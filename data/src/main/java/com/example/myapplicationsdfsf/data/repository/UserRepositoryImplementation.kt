package com.example.myapplicationsdfsf.data.repository

import android.content.Context
import com.example.myapplicationsdfsf.data.storage.UserStorage
import com.example.myapplicationsdfsf.data.storage.models.User
import com.example.myapplicationsdfsf.domain.models.SaveUserNameParam
import com.example.myapplicationsdfsf.domain.models.UserName
import com.example.myapplicationsdfsf.domain.repository.UserRepository


private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_NAME = "Default last name"

class UserRepositoryImplementation(private val userStorage: UserStorage) : UserRepository {


    override fun saveName(saveParam : SaveUserNameParam) : Boolean {
        val user = mapToStorage(saveParam)

        val result = userStorage.save(user)

        return result
    }
    override fun getName(): UserName {
        val user = userStorage.get()


        return mapToDomain(user)
    }

    private fun mapToDomain(user : User): UserName {
        return UserName(user.firstName, user.lastName)
    }
    private fun mapToStorage(saveParam : SaveUserNameParam): User {
        return User(saveParam.name, "")
    }
}