package com.android.jokes.common

sealed class BaseResponse<T> {
    data class Success<T>(val data: T) : BaseResponse<T>()
    data class Error<T>(val errorMessage: String) : BaseResponse<T>()
}