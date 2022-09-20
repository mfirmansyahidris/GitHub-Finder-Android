package com.fi.githubfinder.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fi.githubfinder.data.models.ResponseGitRepositories
import com.fi.githubfinder.data.repositories.GitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

15/09/2022, 01:26 pm
 ****************************************
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: GitRepository
) : ViewModel() {

    val countDown = flow {
        val startingValue = 20
        var currentValue = startingValue
        emit(startingValue)
        while(currentValue > 0){
            delay(1000)
            currentValue--
            emit(currentValue)
        }
    }

//    val uiState = flow{
//        emit(HomeUIState(isLoading = true))
//        repository.getGit(
//            query = "Doraemon",
//            page = 1,
//            perPage = 10
//        )
//        emit(HomeUIState(isLoading = false))
//    }

}