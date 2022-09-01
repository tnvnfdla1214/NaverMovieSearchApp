package com.flowassignment.navermoviesearchapp.di

import android.content.Context
import androidx.room.Room
import com.flowassignment.navermoviesearchapp.data.local.ApplicationDatabase
import com.flowassignment.navermoviesearchapp.data.local.dao.LatestWordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDBModule {
    @Provides
    @Singleton
    fun providesLatestWordDao(appdatabase: ApplicationDatabase): LatestWordDao =
        appdatabase.latestWordDao()

    @Provides
    @Singleton
    fun providesLatestWordDatabase(@ApplicationContext context: Context): ApplicationDatabase =
        Room.databaseBuilder(context, ApplicationDatabase::class.java, "LatestWord.db").build()

}