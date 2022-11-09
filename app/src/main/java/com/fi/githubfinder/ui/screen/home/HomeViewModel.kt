package com.fi.githubfinder.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fi.githubfinder.data.models.GitData
import com.fi.githubfinder.data.repositories.GitRepository
import com.fi.githubfinder.utils.Async
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import com.fi.githubfinder.data.Result
import com.fi.githubfinder.utils.WhileUiSubscribed

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

    init {
        loadData()
    }

    val uiState: StateFlow<HomeUIState> =
        repository.getDataStream()
            .map { Async.Success(it) }
            .onStart<Async<Result<List<GitData?>>>> { emit(Async.Loading) }
            .map { dataAsync -> produceStatisticsUiState(dataAsync) }
            .stateIn(
                scope = viewModelScope,
                started = WhileUiSubscribed,
                initialValue = HomeUIState(isLoading = true)
            )

    private fun loadData(){
        viewModelScope.launch {
            repository.search(
                query = "doraemon",
                perPage = 20,
                page = 1
            )
        }
    }

    private fun produceStatisticsUiState(data: Async<Result<List<GitData?>>>) =
        when (data) {
            Async.Loading -> {
                HomeUIState(isLoading = true, isEmpty = true)
            }
            is Async.Success -> {
                when (val result = data.data) {
                    is Result.Success -> {
                        HomeUIState(
                            isEmpty = result.data.isEmpty(),
                            data = result.data,
                            isLoading = false
                        )
                    }
                    is Result.Error -> {
                        HomeUIState(
                            error = HomeUIError(
                                code = 0,
                                message = result.exception.message
                            )
                        )
                    }
                    else -> HomeUIState(isLoading = false)
                }
            }
        }

}