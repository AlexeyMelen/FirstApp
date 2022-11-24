package com.example.firstapp.di

import com.example.firstapp.di.modules.DatabaseModule
import com.example.firstapp.di.modules.DomainModule
import com.example.firstapp.di.modules.RemoteModule
import com.example.firstapp.viewmodel.HomeFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
}