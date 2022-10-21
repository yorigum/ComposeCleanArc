package com.yoriworks.data.repository.dataSourceImpl

import com.yoriworks.data.api.MovieApi
import com.yoriworks.data.repository.dataSource.MovieRemoteDataSource
import com.yoriworks.domain.model.MovieList
import com.yoriworks.yomovies.BuildConfig
import retrofit2.Response

class MoveRemoteDataSourceImpl(private val movieApi: MovieApi):MovieRemoteDataSource {
    override suspend fun getPopularMovies() = movieApi.getPopularMovies(BuildConfig.API_KEY)

}