package com.yoriworks.domain.repository

import com.yoriworks.domain.model.MovieList
import com.yoriworks.domain.util.Result

interface MovieRepository {
    suspend fun getPopularMovies(): Result<MovieList>
}