package com.warisdgk.di

import android.content.Context
import com.warisdgk.data.local.AppDatabase
import com.warisdgk.data.local.PostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    fun providePostsDao(appDatabase: AppDatabase): PostDao {
        return appDatabase.postDao()
    }
}