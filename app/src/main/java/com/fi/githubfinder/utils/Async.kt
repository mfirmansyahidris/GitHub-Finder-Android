package com.fi.githubfinder.utils

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

19/09/2022, 10:19 am
 ****************************************
 */

sealed class Async<out T>{
    object Loading: Async<Nothing>()
    data class Success<out T>(val data: T): Async<T>()
}