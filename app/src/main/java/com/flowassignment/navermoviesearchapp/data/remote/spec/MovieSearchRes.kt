package com.flowassignment.navermoviesearchapp.data.remote.spec

import com.google.gson.annotations.SerializedName
import java.util.*

class MovieSearchRes(
    @SerializedName("items") var items: Array<Items>
) {
    data class Items(
        @SerializedName("title")
        val title: String,
        @SerializedName("link")
        val link: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("pubDate")
        val pubDate: String,
        @SerializedName("userRating")
        val userRating: String
    )
}