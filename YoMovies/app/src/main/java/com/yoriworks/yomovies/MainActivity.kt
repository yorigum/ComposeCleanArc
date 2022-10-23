package com.yoriworks.yomovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yoriworks.yomovies.presentation.navigation.NavGraph
import com.yoriworks.yomovies.ui.theme.YoMoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YoMoviesTheme {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}