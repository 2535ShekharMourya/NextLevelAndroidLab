package com.azad.masterrecyclerview.localroomdatabase.interfaces

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.azad.masterrecyclerview.localroomdatabase.PostEntity
import com.azad.masterrecyclerview.localroomdatabase.UserEntity

interface PostsDao {
    @Query("SELECT * FROM users")
    suspend fun getAllPosts(): List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<PostEntity>)
}