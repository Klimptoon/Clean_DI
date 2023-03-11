package com.example.myapplicationsdfsf.app

import android.app.Application
import com.example.myapplicationsdfsf.di.AppComponent
import com.example.myapplicationsdfsf.di.AppModule
import com.example.myapplicationsdfsf.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}