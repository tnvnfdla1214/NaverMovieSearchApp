package com.flowassignment.navermoviesearchapp.data.remote.network

import com.flowassignment.navermoviesearchapp.data.remote.spec.MovieSearchRes
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieSearchAPI {
    @GET("v1/search/movie.json")
    fun getSearch(
        @Header("X-Naver-Client-Id") clientId: String,
        @Header("X-Naver-Client-Secret") clientPw: String,
        @Query("query") query: String
    ): Call<MovieSearchRes>
}