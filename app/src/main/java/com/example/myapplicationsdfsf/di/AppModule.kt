package com.example.myapplicationsdfsf.di

import android.content.Context
import com.example.myapplicationsdfsf.domain.usecase.GetUserNameUseCase
import com.example.myapplicationsdfsf.domain.usecase.SaveUserNameUseCase
import com.example.myapplicationsdfsf.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext() : Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(getUserNameUseCase, saveUserNameUseCase)
    }

}