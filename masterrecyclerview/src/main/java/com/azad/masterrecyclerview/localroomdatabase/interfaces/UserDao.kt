package com.azad.masterrecyclerview.localroomdatabase.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.azad.masterrecyclerview.localroomdatabase.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserEntity>)
}