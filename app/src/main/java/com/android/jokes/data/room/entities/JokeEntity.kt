package com.android.jokes.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.jokes.common.Constants
import com.android.jokes.domain.model.Joke

@Entity(tableName = Constants.TABLE_JOKES)
data class JokeEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "joke")
    var joke: String,

    )

fun JokeEntity.toJoke(): Joke {
    return Joke(joke = joke)
}

