package com.example.myapplicationsdfsf.di

import android.content.Context
import com.example.myapplicationsdfsf.data.repository.UserRepositoryImplementation
import com.example.myapplicationsdfsf.data.storage.UserStorage
import com.example.myapplicationsdfsf.data.storage.sharedrefs.SharedPrefUserStorage
import com.example.myapplicationsdfsf.domain.repository.UserRepository
import dagger.Module
import dagger.Provides


@Module
class DataModule {



    @Provides
    fun provideUserStorage(context : Context) :  UserStorage{
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage : UserStorage) : UserRepository {
        return UserRepositoryImplementation(userStorage = userStorage)
    }

}