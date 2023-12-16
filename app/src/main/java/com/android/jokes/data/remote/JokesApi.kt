package com.android.jokes.data.remote

import com.android.jokes.data.remote.joke_dto.JokeDto
import retrofit2.http.GET

interface JokesApi {

    @GET("api?format=json")
    suspend fun getJoke(): JokeDto
}