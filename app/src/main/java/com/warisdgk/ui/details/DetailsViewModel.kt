package com.warisdgk.ui.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.warisdgk.data.repository.PostsRepository

class DetailsViewModel @ViewModelInject constructor(
    private val repository: PostsRepository
) : ViewModel() {

    private val _id = MutableLiveData<Int>()

    private val _post = _id.switchMap { id ->
        repository.getPostFromLocalSource(id)
    }
    val localPost = _post

    fun setPostId(postId: Int) {
        _id.value = postId
    }

}
