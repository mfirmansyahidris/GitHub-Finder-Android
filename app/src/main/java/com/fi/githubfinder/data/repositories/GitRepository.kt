package com.fi.githubfinder.data.repositories

import com.fi.githubfinder.data.models.GitData
import com.fi.githubfinder.data.source.GitRemoteDataSource
import kotlinx.coroutines.flow.Flow
import com.fi.githubfinder.data.Result
import javax.inject.Inject

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

15/09/2022, 01:48 pm
 ****************************************
 */

class GitRepository @Inject constructor(private val remoteDataSource: GitRemoteDataSource) {
    fun getDataStream(): Flow<Result<List<GitData?>>> {
        return remoteDataSource.getDataStream()
    }

    suspend fun search(query: String, page: Int, perPage: Int){
        return remoteDataSource.search(
            query = query,
            page = page,
            perPage = perPage
        )
    }
}