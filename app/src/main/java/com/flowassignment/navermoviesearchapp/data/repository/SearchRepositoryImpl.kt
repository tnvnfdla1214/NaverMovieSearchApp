package com.flowassignment.navermoviesearchapp.data.repository

import android.util.Log
import com.flowassignment.navermoviesearchapp.data.remote.network.MovieSearchAPI
import com.flowassignment.navermoviesearchapp.data.remote.url.SearchMovieUrl
import com.flowassignment.navermoviesearchapp.domain.entity.DataResult
import com.flowassignment.navermoviesearchapp.domain.entity.Movie
import com.flowassignment.navermoviesearchapp.domain.mapper.MoviewMapper
import com.flowassignment.navermoviesearchapp.domain.repository.SearchRepository
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
                    api.getSearch(SearchMovieUrl.Client_Id, SearchMovieUrl.clientPw, keyward).execute().body()
                when {
                    response == null -> {
                        Log.d("민규","1")
                        DataResult.Error("서버와 연결 오류")
                    }
                    response.items.isEmpty() -> {
                        DataResult.NoData
                    }
                    else -> {
                        val result: List<Movie> = response.items.map {
                            MoviewMapper.MovieResToMovie(it)
                        }
                        DataResult.Success(result)
                    }
                }
            } catch (e: Exception) {
                Log.e("민규",e.toString())
                DataResult.Error("서버와 연결 오류")
            }
        }
}