package com.android.jokes.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.android.jokes.R
import com.android.jokes.presentation.jokes_listing.JokesListingScreen
import com.android.jokes.presentation.topbar.TopBar

@Composable
fun JokesApp() {
    Scaffold(topBar = {
        TopBar(
            title = stringResource(id = R.string.app_name),
        )
    }) { paddingValues ->
        JokesListingScreen(paddingValues = paddingValues)
    }
}