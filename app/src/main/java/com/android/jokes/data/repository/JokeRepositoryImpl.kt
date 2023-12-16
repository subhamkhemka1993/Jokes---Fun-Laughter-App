package com.android.jokes.data.repository

import com.android.jokes.common.BaseResponse
import com.android.jokes.data.remote.JokesApi
import com.android.jokes.data.remote.joke_dto.toJokeEntity
import com.android.jokes.data.room.daos.JokeDao
import com.android.jokes.data.room.entities.JokeEntity
import com.android.jokes.data.room.entities.toJoke
import com.android.jokes.domain.model.Joke
import com.android.jokes.domain.repository.JokeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class JokeRepositoryImpl @Inject constructor(
    private val jokesApi: JokesApi,
    private val jokeDao: JokeDao,
) : JokeRepository {

    override suspend fun fetchJoke() {
        try {
            val joke = jokesApi.getJoke()
            insertJokeToDb(jokeEntity = joke.toJokeEntity())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override suspend fun insertJokeToDb(jokeEntity: JokeEntity) {
        jokeDao.addJoke(jokeEntity = jokeEntity)
    }

    override suspend fun getAllJokes(): Flow<BaseResponse<List<Joke>>> {
        return jokeDao.getAllJokes()
            .map { data ->
                BaseResponse.Success(data.map { it.toJoke()})
            }
            .catch { exception ->
                BaseResponse.Error<List<Joke>>(exception.message.orEmpty())
            }
    }

}