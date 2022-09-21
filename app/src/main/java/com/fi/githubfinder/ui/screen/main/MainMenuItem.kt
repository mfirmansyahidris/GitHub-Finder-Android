package com.fi.githubfinder.ui.screen.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

21/09/2022, 03:06 pm
 ****************************************
 */

enum class MainMenuItem(
    val icon: ImageVector,
    val menu: String,
) {
    Home(icon = Icons.Default.Home, menu = "Home"),
    Favorite(icon = Icons.Default.Favorite, menu = "Favorite"),
    About(icon = Icons.Default.Info, menu = "About")
}