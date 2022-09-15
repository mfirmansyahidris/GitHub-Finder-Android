package com.fi.githubfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fi.githubfinder.ui.screen.Screen
import com.fi.githubfinder.ui.screen.SplashScreen
import com.fi.githubfinder.ui.screen.home.HomeScreen
import com.fi.githubfinder.ui.theme.GithubFinderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    GithubFinderTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Screen.Splash.name,
        ) {
            composable(Screen.Splash.name) {
                SplashScreen(navController)
            }
            composable(Screen.Home.name) {
                HomeScreen()
            }
        }
    }
}