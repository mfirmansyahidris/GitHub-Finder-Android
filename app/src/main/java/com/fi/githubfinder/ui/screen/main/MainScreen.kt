package com.fi.githubfinder.ui.screen.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fi.githubfinder.R
import com.fi.githubfinder.ui.screen.about.AboutScreen
import com.fi.githubfinder.ui.screen.favorite.FavoriteScreen
import com.fi.githubfinder.ui.screen.home.HomeScreen

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

21/09/2022, 03:19 pm
 ****************************************
 */

@Preview
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }
        },
        bottomBar = { BottomNavigation(navController = navController) },
    ) {
        NavigationGraph(navController = navController)
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        MainMenuItem.Home,
        MainMenuItem.Favorite,
        MainMenuItem.About,
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.name) },
                label = { Text(
                        text = item.menu,
                        fontSize = 12.sp
                ) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.name,
                onClick = {
                    navController.navigate(item.name) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = MainMenuItem.Home.name) {
        composable(MainMenuItem.Home.name) {
            HomeScreen()
        }
        composable(MainMenuItem.Favorite.name) {
            FavoriteScreen()
        }
        composable(MainMenuItem.About.name) {
            AboutScreen()
        }
    }
}