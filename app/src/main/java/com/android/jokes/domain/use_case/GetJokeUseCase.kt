package com.android.jokes.domain.use_case

import com.android.jokes.domain.repository.JokeRepository
import javax.inject.Inject


class GetJokeUseCase @Inject constructor(
    private val jokeRepository: JokeRepository,
) {

    suspend operator fun invoke() = jokeRepository.getAllJokes()

}