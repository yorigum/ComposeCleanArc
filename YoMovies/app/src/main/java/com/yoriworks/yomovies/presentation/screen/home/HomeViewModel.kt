package com.yoriworks.yomovies.presentation.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoriworks.domain.model.MovieList
import com.yoriworks.domain.useCase.GetPopularMoviesUseCase
import com.yoriworks.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
    ):ViewModel(){
    private val _movieState = mutableStateOf<Result<MovieList>>(Result.Loading())
    val movieState: State<Result<MovieList>> = _movieState

    init{
        getPopularMovies()
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            _movieState.value =  getPopularMoviesUseCase()
        }
    }
}