package com.azad.masterrecyclerview.localroomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val username: String,
    val website: String
)
