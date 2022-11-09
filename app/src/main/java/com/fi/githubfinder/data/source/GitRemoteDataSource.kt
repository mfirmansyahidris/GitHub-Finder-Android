package com.fi.githubfinder.data.source

import com.fi.githubfinder.api.RestApi
import com.fi.githubfinder.data.Result
import com.fi.githubfinder.data.Result.Success
import com.fi.githubfinder.data.Result.Error
import com.fi.githubfinder.data.Result.Init
import com.fi.githubfinder.data.models.GitData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

03/10/2022, 10:12 am
 ****************************************
 */

class GitRemoteDataSource @Inject constructor(private val api: RestApi) {
    private val observableData = MutableStateFlow<Result<List<GitData?>>>(Init)

    suspend fun search(query: String, page: Int, perPage: Int){
        observableData.value = getData(
            query = query,
            page = page,
            perPage = perPage
        )
    }

    private suspend fun getData(query: String, page: Int, perPage: Int): Result<List<GitData?>> {
        val response = api.getGit(
            query = query,
            page = page,
            perPage= perPage
        )

        return if(response.code() == 200 || response.code() == 201){
            Success(response.body()?.items ?: listOf())
        }else{
            Error(Exception(response.message()))
        }
    }

    fun getDataStream(): Flow<Result<List<GitData?>>> {
        return observableData.map { data ->
            when (data) {
                is Init -> Init
                is Error -> Error(data.exception)
                is Success -> Success(data.data)
            }
        }
    }
}