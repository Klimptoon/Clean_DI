package com.example.myapplicationsdfsf.domain.usecase

import com.example.myapplicationsdfsf.domain.models.UserName
import com.example.myapplicationsdfsf.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute() : UserName {
        return userRepository.getName()
    }
}