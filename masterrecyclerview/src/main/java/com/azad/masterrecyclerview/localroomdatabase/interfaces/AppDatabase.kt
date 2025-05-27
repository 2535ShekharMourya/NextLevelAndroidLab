package com.azad.masterrecyclerview.localroomdatabase.interfaces

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.azad.masterrecyclerview.localroomdatabase.PostEntity
import com.azad.masterrecyclerview.localroomdatabase.UserEntity

@Database(entities = [UserEntity::class,PostEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun postDao(): PostsDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}