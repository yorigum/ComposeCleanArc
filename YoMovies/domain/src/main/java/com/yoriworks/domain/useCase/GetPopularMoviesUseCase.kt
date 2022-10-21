package com.yoriworks.domain.useCase

import com.yoriworks.domain.repository.MovieRepository

class GetPopularMoviesUseCase(private val movieRepository:MovieRepository) {
    suspend fun invoke()=movieRepository.getPopularMovies()
}