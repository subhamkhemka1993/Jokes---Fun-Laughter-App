package com.android.jokes.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.jokes.data.room.daos.JokeDao
import com.android.jokes.data.room.entities.JokeEntity


@Database(entities = [JokeEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val jokeDao: JokeDao
}