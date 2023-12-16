package com.android.jokes.presentation.jokes_listing

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun JokesListingScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(),
) {

    val jokesViewModel: JokesViewModel = hiltViewModel()
    val jokesList = jokesViewModel.listOfJokes.collectAsState().value

    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues),
        color = MaterialTheme.colorScheme.background
    ) {
        JokesScreenContainer(jokesList = jokesList)
    }

}