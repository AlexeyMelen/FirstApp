package com.example.firstapp.di.modules

import android.content.Context
import com.example.firstapp.data.MainRepository
import com.example.firstapp.data.db.DatabaseHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabaseHelper(context: Context): DatabaseHelper = DatabaseHelper(context)
    
    @Provides
    @Singleton
    fun provideRepository(databaseHelper: DatabaseHelper) = MainRepository(databaseHelper)
}