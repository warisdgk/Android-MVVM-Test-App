package com.warisdgk.di

import com.warisdgk.data.remote.PostsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providePostsService(): PostsService {
        return PostsService.create()
    }
}
