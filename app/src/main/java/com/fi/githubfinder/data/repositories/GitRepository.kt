package com.fi.githubfinder.data.repositories

import com.fi.githubfinder.api.RestApi
import com.fi.githubfinder.config.NetworkConfig
import com.fi.githubfinder.data.models.ResponseGitRepositories
import javax.inject.Inject

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

15/09/2022, 01:48 pm
 ****************************************
 */

class GitRepository @Inject constructor(private val api: RestApi) {
    suspend fun getGit(query: String, page: Int,  perPage: Int): ResponseGitRepositories {
        return api.getGit(
            query = query,
            page = page,
            perPage= perPage
        )
    }
}