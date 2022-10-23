package com.yoriworks.yomovies.di

import com.yoriworks.domain.repository.MovieRepository
import com.yoriworks.domain.useCase.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetPopularMoviesUseCase(movieRepository: MovieRepository) =
       GetPopularMoviesUseCase(movieRepository)
}