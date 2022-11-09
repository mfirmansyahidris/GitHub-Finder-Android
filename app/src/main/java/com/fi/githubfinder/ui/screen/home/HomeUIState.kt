package com.fi.githubfinder.ui.screen.home

import com.fi.githubfinder.data.models.GitData

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

15/09/2022, 04:42 pm
 ****************************************
 */

data class HomeUIState (
    val isEmpty: Boolean = false,
    val isLoading: Boolean = false,
    val data: List<GitData?> = listOf(),
    val error: HomeUIError? = null
)

data class HomeUIError(
    val code: Int?,
    val message: String?
)