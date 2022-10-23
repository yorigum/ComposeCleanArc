package com.yoriworks.yomovies.di

import com.yoriworks.data.repository.MovieRepositoryImpl
import com.yoriworks.data.repository.dataSource.MovieRemoteDataSource
import com.yoriworks.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMoviesRepository(movieRemoteDataSource: MovieRemoteDataSource) : MovieRepository =
        MovieRepositoryImpl(movieRemoteDataSource)
}