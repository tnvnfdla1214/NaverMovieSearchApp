package com.flowassignment.navermoviesearchapp.di

import com.flowassignment.navermoviesearchapp.data.local.dao.LatestWordDao
import com.flowassignment.navermoviesearchapp.data.repository.LatestWordRepositoryImpl
import com.flowassignment.navermoviesearchapp.data.remote.network.MovieSearchAPI
import com.flowassignment.navermoviesearchapp.data.repository.SearchRepositoryImpl
import com.flowassignment.navermoviesearchapp.domain.repository.latestword.LatestWordRepository
import com.flowassignment.navermoviesearchapp.domain.repository.search.SearchRepository
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

    @Singleton
    @Provides
    fun privideLatestWordRepository(
        latestWordDao: LatestWordDao,
        @DispatcherModule.IoDispatcher ioDispatcher: CoroutineDispatcher
    ): LatestWordRepository = LatestWordRepositoryImpl(latestWordDao, ioDispatcher)

}