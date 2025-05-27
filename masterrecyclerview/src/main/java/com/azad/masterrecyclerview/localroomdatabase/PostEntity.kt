package com.azad.masterrecyclerview.localroomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostEntity(
    val body: String,
    val email: String,
    val name: String,
    val postId: Int,

    @PrimaryKey
    val id: Int
)