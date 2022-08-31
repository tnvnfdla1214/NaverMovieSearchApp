package com.flowassignment.navermoviesearchapp.domain.repository

import com.flowassignment.navermoviesearchapp.domain.entity.DataResult
import com.flowassignment.navermoviesearchapp.domain.entity.Movie

interface SearchRepository {
    suspend fun getSearchMovieList(keyward : String): DataResult<List<Movie>>
}