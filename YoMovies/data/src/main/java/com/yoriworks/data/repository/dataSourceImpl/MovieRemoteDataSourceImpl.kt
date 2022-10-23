package com.yoriworks.data.repository.dataSourceImpl

import com.yoriworks.data.BuildConfig
import com.yoriworks.data.api.MovieApi
import com.yoriworks.data.repository.dataSource.MovieRemoteDataSource

class MovieRemoteDataSourceImpl(private val movieApi: MovieApi):MovieRemoteDataSource {
    override suspend fun getPopularMovies() = movieApi.getPopularMovies(BuildConfig.API_KEY)
}