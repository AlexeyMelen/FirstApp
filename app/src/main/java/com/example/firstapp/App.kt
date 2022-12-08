package com.example.firstapp

import android.app.Application
import com.example.firstapp.di.AppComponent
import com.example.firstapp.di.DaggerAppComponent
import com.example.firstapp.di.modules.DatabaseModule
import com.example.firstapp.di.modules.DomainModule
import com.example.firstapp.di.modules.RemoteModule

class App : Application() {

    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
    instance = this
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
}

companion object {
    lateinit var instance: App
        private set
    }
}