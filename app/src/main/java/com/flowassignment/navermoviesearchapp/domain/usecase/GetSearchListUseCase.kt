package com.flowassignment.navermoviesearchapp.domain.usecase

import com.flowassignment.navermoviesearchapp.domain.entity.DataResult
import com.flowassignment.navermoviesearchapp.domain.entity.Movie
import com.flowassignment.navermoviesearchapp.domain.repository.SearchRepository
import javax.inject.Inject

class GetSearchListUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) {
    suspend operator fun invoke(keyword:String): DataResult<List<Movie>> {
        return searchRepository.getSearchMovieList(keyword)
    }
}