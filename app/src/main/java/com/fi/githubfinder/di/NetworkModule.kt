package com.fi.githubfinder.di

import com.fi.githubfinder.api.RestApi
import com.fi.githubfinder.config.NetworkConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/07/2022, 05:06 pm
 ****************************************
 */

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideUnsplashService(): RestApi {
        return NetworkConfig().create()
    }
}