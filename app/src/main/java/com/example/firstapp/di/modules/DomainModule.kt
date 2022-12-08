package com.example.firstapp.di.modules

import android.content.Context
import com.example.firstapp.App
import com.example.firstapp.data.MainRepository
import com.example.firstapp.data.TmdbApi
import com.example.firstapp.data.preferenes.PreferenceProvider
import com.example.firstapp.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule(val context: Context) {
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    fun providePreferences(context: Context) = PreferenceProvider(context)

    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi, preferenceProvider: PreferenceProvider) = Interactor(repo = repository, retrofitService = tmdbApi, preferences = preferenceProvider)
}