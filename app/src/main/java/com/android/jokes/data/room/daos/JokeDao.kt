package com.android.jokes.data.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.jokes.data.room.entities.JokeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface JokeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addJoke(jokeEntity: JokeEntity)

    @Query("SELECT * FROM (SELECT * FROM jokes ORDER BY id DESC LIMIT 10 )Var1 ORDER BY id ASC")
    fun getAllJokes(): Flow<List<JokeEntity>>
}