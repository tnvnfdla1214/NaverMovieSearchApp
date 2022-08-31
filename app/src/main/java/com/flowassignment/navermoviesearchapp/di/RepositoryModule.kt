package com.flowassignment.navermoviesearchapp.di

import com.flowassignment.navermoviesearchapp.data.remote.network.MovieSearchAPI
import com.flowassignment.navermoviesearchapp.data.repository.SearchRepositoryImpl
import com.flowassignment.navermoviesearchapp.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideSearchRepository(
        api: MovieSearchAPI,
        @DispatcherModule.IoDispatcher ioDispatcher: CoroutineDispatcher
    ): SearchRepository = SearchRepositoryImpl(api, ioDispatcher)
}