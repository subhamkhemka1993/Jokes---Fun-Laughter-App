package com.android.jokes.presentation.jokes_listing.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.jokes.ui.theme.JokesFunLaughterTheme

@Composable
fun JokeCell(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = name,
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colorScheme.onSecondaryContainer)
            .padding(8.dp),
        color = MaterialTheme.colorScheme.onSecondary
    )
}

@Preview
@Composable
fun PreviewJokeCell() {
    JokesFunLaughterTheme {
        JokeCell("Android")
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewJokeCellDarkMode() {
    JokesFunLaughterTheme {
        JokeCell("Android")
    }
}