package com.fi.githubfinder.ui.screen.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.fi.githubfinder.data.repositories.GitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
    var isLoading = MutableStateFlow(false)

    fun getGit() {
        CoroutineScope(Dispatchers.IO).launch {
            isLoading.value = true
            val response = repository.getGit(
                query = "Doraemon",
                page = 1,
                perPage = 10
            )
            withContext(Dispatchers.Main) {
                Log.d("DEBUG", response.toString())
                isLoading.value = false
            }
        }
    }

}