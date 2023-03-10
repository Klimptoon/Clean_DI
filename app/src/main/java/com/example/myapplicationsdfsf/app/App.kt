package com.example.myapplicationsdfsf.app

import android.app.Application
import com.example.myapplicationsdfsf.di.appModule
import com.example.myapplicationsdfsf.di.dataModule
import com.example.myapplicationsdfsf.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}