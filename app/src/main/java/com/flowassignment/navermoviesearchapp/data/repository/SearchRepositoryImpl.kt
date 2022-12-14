package com.flowassignment.navermoviesearchapp.data.repository

import android.util.Log
import com.flowassignment.navermoviesearchapp.data.remote.network.MovieSearchAPI
import com.flowassignment.navermoviesearchapp.data.remote.url.SearchMovieUrl
import com.flowassignment.navermoviesearchapp.domain.entity.DataResult
import com.flowassignment.navermoviesearchapp.domain.entity.Movie
import com.flowassignment.navermoviesearchapp.domain.mapper.MoviewMapper
import com.flowassignment.navermoviesearchapp.domain.repository.search.SearchRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SearchRepositoryImpl(
    private val api: MovieSearchAPI,
    private val ioDispatcher: CoroutineDispatcher
) : SearchRepository {
    override suspend fun getSearchMovieList(keyward: String): DataResult<List<Movie>> =
        withContext(ioDispatcher) {
            try {
                val response =
                    api.getSearch(SearchMovieUrl.Client_Id, SearchMovieUrl.clientPw, keyward)
                        .execute().body()
                when {
                    response == null -> {
                        DataResult.Error("서버와 연결 오류")
                    }
                    response.items.isEmpty() -> {
                        DataResult.NoData
                    }
                    else -> {
                        val result: List<Movie> = response.items.map {
                            var title = it.title.replace("<b>", "")
                            title = title.replace("</b>", "")
                            MoviewMapper.MovieResToMovie(it, title)
                        }
                        DataResult.Success(result)
                    }
                }
            } catch (e: Exception) {
                Log.e("민규", e.toString())
                DataResult.Error("서버와 연결 오류")
            }
        }
}