package com.flowassignment.navermoviesearchapp.domain.entity

data class Movie(
    val title: String,
    val link: String,
    val image: String?,
    val pubDate: String?,
    val userRating: String,
)
