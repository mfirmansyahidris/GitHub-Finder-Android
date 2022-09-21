package com.fi.githubfinder.ui.screen

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

28/07/2022, 12:45 pm
 ****************************************
 */

enum class Screen{
    Splash,
    Main;

    companion object{
        fun fromRoute(route: String?): Screen =
            when(route?.substringBefore("/")){
                Splash.name -> Splash
                Main.name -> Main
                null -> Splash
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}