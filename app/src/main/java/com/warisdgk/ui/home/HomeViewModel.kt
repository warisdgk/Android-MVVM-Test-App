package com.warisdgk.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.warisdgk.data.repository.PostsRepository

class HomeViewModel @ViewModelInject constructor(
    private val repository: PostsRepository
) : ViewModel() {

    var allowNavigate: Boolean = false
    private val _id = MutableLiveData<Int>()

    private val _post = _id.switchMap { id ->
        repository.getPost(id)
    }
    val postData = _post

    fun setPostId(postId: Int) {
        _id.value = postId
    }

}
