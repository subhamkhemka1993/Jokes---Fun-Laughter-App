package com.android.jokes.domain.repository

import com.android.jokes.common.BaseResponse
import com.android.jokes.data.room.entities.JokeEntity
import com.android.jokes.domain.model.Joke
import kotlinx.coroutines.flow.Flow

interface JokeRepository {

    suspend fun fetchJoke()
    suspend fun insertJokeToDb(jokeEntity: JokeEntity)
    suspend fun getAllJokes(): Flow<BaseResponse<List<Joke>>>
}