package com.example.firstapp

import android.app.Application
import com.example.firstapp.di.AppComponent
import com.example.firstapp.di.DaggerAppComponent

class App : Application() {

    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
    instance = this
    dagger = DaggerAppComponent.create()
}

companion object {
    lateinit var instance: App
        private set
    }
}