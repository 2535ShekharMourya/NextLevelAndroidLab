package com.azad.masterrecyclerview.repository

import com.azad.masterrecyclerview.localroomdatabase.UserEntity
import com.azad.masterrecyclerview.localroomdatabase.interfaces.UserDao
import com.azad.masterrecyclerview.networking.RetrofitInstance

class UserRepository(private val userDao: UserDao) {

    suspend fun getUsers(isConnected: Boolean): List<UserEntity> {
        return if (isConnected) {
            val usersFromApi = RetrofitInstance.api.getUsers()
            val userEntities = usersFromApi.map {
                UserEntity(it.id,it.name, it.email, it.phone,it.username,it.website)
            }
            userDao.insertUsers(userEntities)
            userEntities
        } else {
            userDao.getAllUsers()
        }
    }
}