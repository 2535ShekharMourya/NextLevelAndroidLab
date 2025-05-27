package com.azad.masterrecyclerview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.azad.masterrecyclerview.localroomdatabase.UserEntity
import com.azad.masterrecyclerview.localroomdatabase.interfaces.AppDatabase
import com.azad.masterrecyclerview.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = AppDatabase.getDatabase(application).userDao()
    private val repository = UserRepository(userDao)

    private val _users = MutableLiveData<List<UserEntity>>()
    val users: LiveData<List<UserEntity>> = _users

    fun loadUsers(isConnected: Boolean) {
        viewModelScope.launch {
            val userList = repository.getUsers(isConnected)
            _users.postValue(userList)
        }
    }
}