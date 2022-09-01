package com.flowassignment.navermoviesearchapp.domain.repository.search

import com.flowassignment.navermoviesearchapp.domain.entity.DataResult
import com.flowassignment.navermoviesearchapp.domain.entity.Movie

interface SearchRepository {
    suspend fun getSearchMovieList(keyword: String): DataResult<List<Movie>>
}