package com.warisdgk.data.remote

import javax.inject.Inject

class PostsRemoteDataSource @Inject constructor(
    private val postsService: PostsService
) : BaseDataSource() {
    suspend fun getPost(id: Int) = getResult { postsService.fetchPost(id) }
}