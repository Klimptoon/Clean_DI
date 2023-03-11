package com.example.myapplicationsdfsf.di

import com.example.myapplicationsdfsf.presentation.MainActivity
import dagger.Component


@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}