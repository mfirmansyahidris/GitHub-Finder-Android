package com.fi.githubfinder.api

import com.fi.githubfinder.config.NetworkConfig
import com.fi.githubfinder.data.models.ResponseGitRepositories
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/07/2022, 04:21 pm
 ****************************************
 */

interface RestApi {
    @GET("search/repositories")
    suspend fun getGit(
        @Query("q") query: String?,
        @Query("page") page: Int = 0,
        @Query("per_page") perPage: Int = 0,
    ): Response<ResponseGitRepositories>
}