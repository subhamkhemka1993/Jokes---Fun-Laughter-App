package com.android.jokes.presentation.jokes_listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.jokes.common.BaseResponse
import com.android.jokes.domain.model.Joke
import com.android.jokes.domain.use_case.FetchJokeUseCase
import com.android.jokes.domain.use_case.GetJokeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokesViewModel @Inject constructor(
    private val getJokeUseCase: GetJokeUseCase,
    private val fetchJokeUseCase: FetchJokeUseCase,
) : ViewModel() {

    private var _mutableJokeList = MutableStateFlow<List<Joke>>(emptyList())
    val listOfJokes: StateFlow<List<Joke>> = _mutableJokeList

    init {
        getJokes()
        fetchRemoteJokes()
    }

    private fun fetchRemoteJokes() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchJokeUseCase.invoke()
        }
    }

    fun getJokes() {
        viewModelScope.launch(Dispatchers.IO) {
            getJokeUseCase().collect {
                when (it) {
                    is BaseResponse.Error -> {}
                    is BaseResponse.Success -> {
                        _mutableJokeList.value = it.data
//                        listOfJokes.add(listOfJokes.lastIndex + 1, it.data)
                    }
                }
            }
        }
    }

}