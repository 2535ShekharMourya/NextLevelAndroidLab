package com.azad.masterrecyclerview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.azad.masterrecyclerview.localroomdatabase.PostEntity
import com.azad.masterrecyclerview.localroomdatabase.UserEntity
import com.azad.masterrecyclerview.localroomdatabase.interfaces.AppDatabase
import com.azad.masterrecyclerview.repository.PostRepository
import com.azad.masterrecyclerview.repository.UserRepository
import kotlinx.coroutines.launch

class PostsViewmodel(application: Application) : AndroidViewModel(application) {

    private val postDao = AppDatabase.getDatabase(application).postDao()
    private val repository = PostRepository(postDao)

    private val _posts = MutableLiveData<List<PostEntity>>()
    val posts: LiveData<List<PostEntity>> = _posts

    fun loadPosts(isConnected: Boolean) {
        viewModelScope.launch {
            val postList = repository.getPosts(isConnected)
            _posts.postValue(postList)
        }
    }
}