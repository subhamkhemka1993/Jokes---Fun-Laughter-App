package com.android.jokes.data.remote.joke_dto

import com.android.jokes.data.room.entities.JokeEntity

data class JokeDto(
    val joke: String,
)

fun JokeDto.toJokeEntity(): JokeEntity {
    return JokeEntity(joke = joke)
}