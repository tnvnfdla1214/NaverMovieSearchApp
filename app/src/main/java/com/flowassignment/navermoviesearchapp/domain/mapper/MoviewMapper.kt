package com.flowassignment.navermoviesearchapp.domain.mapper

import com.flowassignment.navermoviesearchapp.data.remote.spec.MovieSearchRes
import com.flowassignment.navermoviesearchapp.domain.entity.Movie

object MoviewMapper {
    fun MovieResToMovie(items: MovieSearchRes.Items, title: String): Movie =
        Movie(
            title = title,
            link = items.link,
            image = items.image,
            pubDate = items.pubDate,
            userRating = items.userRating
        )
}