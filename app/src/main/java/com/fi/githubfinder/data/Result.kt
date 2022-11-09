package com.fi.githubfinder.data

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

03/10/2022, 11:18 am
 ****************************************
 */

sealed class Result<out R> {

    object Init: Result<Nothing>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Init -> "Init Request Data"
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}