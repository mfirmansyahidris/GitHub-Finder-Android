package com.fi.githubfinder.utils

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

19/09/2022, 10:19 am
 ****************************************
 */

sealed class Async{
    object Init: Async()
    object Loading: Async()
    data class Error(val code: Int?, val message: String?): Async()
    data class Success<out T>(val data: T): Async()
}