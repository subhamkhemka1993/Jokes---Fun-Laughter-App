package com.android.jokes.domain.use_case

import com.android.jokes.common.Constants
import com.android.jokes.domain.repository.JokeRepository
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import javax.inject.Inject

class FetchJokeUseCase @Inject constructor(
    private val jokeRepository: JokeRepository,
) {
    suspend operator fun invoke() {
        while (currentCoroutineContext().isActive) {
            jokeRepository.fetchJoke()
            delay(Constants.DELAY_1_MIN)
        }
    }
}