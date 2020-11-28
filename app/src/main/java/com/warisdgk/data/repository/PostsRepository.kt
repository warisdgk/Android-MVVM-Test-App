package com.warisdgk.data.repository

import androidx.lifecycle.LiveData
import com.warisdgk.data.entities.Post
import com.warisdgk.data.local.PostDao
import com.warisdgk.data.remote.PostsRemoteDataSource
import com.warisdgk.utilities.performGetOperation
import javax.inject.Inject

class PostsRepository @Inject constructor(
    private val remoteDataSource: PostsRemoteDataSource,
    private val localDataSource: PostDao
) {

    fun getPost(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getPost(id) },
        networkCall = { remoteDataSource.getPost(id) },
        saveCallResult = { localDataSource.insert(it) }
    )

    fun getPostFromLocalSource(id: Int): LiveData<Post> {
        return localDataSource.getPost(id)
    }

}