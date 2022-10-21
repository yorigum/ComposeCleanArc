package com.yoriworks.data.repository

import com.yoriworks.data.repository.dataSource.MovieRemoteDataSource
import com.yoriworks.domain.model.MovieList
import com.yoriworks.domain.repository.MovieRepository
import com.yoriworks.domain.util.Result
import retrofit2.Response

class MovieRepositoryImpl(private val movieRemoteDataSource: MovieRemoteDataSource): MovieRepository{
    override suspend fun getPopularMovies()=responseToRequest(movieRemoteDataSource.getPopularMovies())

    private fun responseToRequest(response: Response<MovieList>):Result<MovieList>{
        if(response.isSuccessful){
            response.body()?.let {
                return Result.Success(it)
            }
        }
       return Result.Error(response.message())
    }
}