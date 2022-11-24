package com.example.firstapp.di.modules

import com.example.firstapp.data.MainRepository
import com.example.firstapp.data.TmdbApi
import com.example.firstapp.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}