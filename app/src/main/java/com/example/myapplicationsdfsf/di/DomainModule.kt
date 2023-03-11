package com.example.myapplicationsdfsf.di

import com.example.myapplicationsdfsf.domain.repository.UserRepository
import com.example.myapplicationsdfsf.domain.usecase.GetUserNameUseCase
import com.example.myapplicationsdfsf.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository : UserRepository) : GetUserNameUseCase {
        return GetUserNameUseCase(userRepository)
    }

    @Provides
    fun provideSaveUserNameUseCase(userRepository : UserRepository) : SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository)
    }

}