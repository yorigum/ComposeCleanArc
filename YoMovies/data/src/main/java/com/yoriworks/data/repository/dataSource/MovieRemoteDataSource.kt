package com.yoriworks.data.repository.dataSource

import com.yoriworks.domain.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getPopularMovies():Response<MovieList>
}