package com.yoriworks.yomovies.presentation.screen.home

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.yoriworks.domain.util.Result
import com.yoriworks.yomovies.R
import com.yoriworks.yomovies.presentation.components.MovieListItem
import com.yoriworks.yomovies.presentation.components.ProgressBar
import com.yoriworks.yomovies.ui.theme.statusBarColor
import com.yoriworks.yomovies.ui.theme.titleColor
import com.yoriworks.yomovies.ui.theme.topAppbarBackgroundColor

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.statusBarColor
    val titleColor = MaterialTheme.colors.titleColor
    val topAppbarBackgroundColor = MaterialTheme.colors.topAppbarBackgroundColor

    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = stringResource(R.string.app_name), color = titleColor)
            },
            backgroundColor = topAppbarBackgroundColor
        )
    }) {
            paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (val movieResponse = viewModel.movieState.value) {
                is Result.Loading -> ProgressBar()
                is Result.Success -> LazyColumn(
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    movieResponse.data?.let { movieList ->
                        items(
                            items = movieList.movies,
                            itemContent = {
                                MovieListItem(movie = it, navController = navController)
                            }
                        )
                    }
                }
                is Result.Error -> Toast.makeText(
                    LocalContext.current,
                    "Something happened . Please try again .",
                    Toast.LENGTH_SHORT
                )
            }
        } }
}

