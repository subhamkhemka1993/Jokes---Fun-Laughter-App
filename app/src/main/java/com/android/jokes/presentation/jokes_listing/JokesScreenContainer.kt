package com.android.jokes.presentation.jokes_listing

import android.content.res.Configuration
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.jokes.domain.model.Joke
import com.android.jokes.presentation.jokes_listing.components.JokeCell
import com.android.jokes.ui.theme.JokesFunLaughterTheme


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun JokesScreenContainer(
    jokesList: List<Joke>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)) {
        items(jokesList) {
            JokeCell(it.joke,
                modifier = Modifier.animateItemPlacement(animationSpec = tween(
                    durationMillis = 500,
                    easing = LinearOutSlowInEasing,
                )))
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewJokesScreenContainer() {
    JokesFunLaughterTheme {
        JokesScreenContainer(jokesList = listOfJokes,
            modifier = Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewJokesScreenContainerDarkMode() {
    JokesFunLaughterTheme {
        JokesScreenContainer(jokesList = listOfJokes,
            modifier = Modifier.fillMaxSize())
    }
}

val listOfJokes = listOf(Joke("Why doesn't Captain Picard have an iPhone He already has an android, and it came with a data plan."), Joke("Why doesn't Captain Picard have an iPhone He already has an android, and it came with a data plan."), Joke("Why doesn't Captain Picard have an iPhone He already has an android, and it came with a data plan."), Joke("Why doesn't Captain Picard have an iPhone He already has an android, and it came with a data plan."))

