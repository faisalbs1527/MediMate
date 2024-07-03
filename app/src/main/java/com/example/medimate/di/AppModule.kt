package com.example.medimate.di

import android.content.Context
import com.example.medimate.db.AppDatabase
import com.example.medimate.repository.ReminderRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAppDB(@ApplicationContext context: Context):AppDatabase{
        return AppDatabase(context)
    }

    @Provides
    @Singleton
    fun provideReminderRepo(appDatabase: AppDatabase):ReminderRepo{
        return ReminderRepo(appDatabase)
    }
}