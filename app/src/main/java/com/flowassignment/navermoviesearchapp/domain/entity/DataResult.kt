package com.flowassignment.navermoviesearchapp.domain.entity

sealed class DataResult<out T> {
    class Success<T>(val data: T) : DataResult<T>()
    object NoData : DataResult<Nothing>()
    class Error(message: String) : DataResult<Nothing>()
}