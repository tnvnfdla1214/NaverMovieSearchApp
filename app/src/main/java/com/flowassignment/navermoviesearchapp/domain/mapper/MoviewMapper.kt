package com.flowassignment.navermoviesearchapp.domain.mapper

import com.flowassignment.navermoviesearchapp.data.remote.spec.MovieSearchRes
import com.flowassignment.navermoviesearchapp.domain.entity.Movie

object MoviewMapper {
    fun MovieResToMovie(items: MovieSearchRes.Items) : Movie =
        Movie(
            title = items.title,
            link = items.link,
            image = items.image,
            pubDate = items.pubDate,
            userRating = items.userRating.toString()
        )
}