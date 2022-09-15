package com.fi.githubfinder.config

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

15/09/2022, 02:27 pm
 ****************************************
 */

@HiltAndroidApp
class ApplicationConfig : Application(){
    override fun onCreate() {
        super.onCreate()
        Log.d("DEBUG", "application started")
    }
}