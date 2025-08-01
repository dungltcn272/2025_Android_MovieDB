package com.nhom4.androidmoviedb.data.mapper

import com.nhom4.androidmoviedb.data.model.MovieItemDto
import com.nhom4.androidmoviedb.domain.model.Movie

fun MovieItemDto.toMovie(): Movie {
    return Movie(
        id = this._id,
        title = this.name,
        thumbUrl = this.thumb_url,
        year = this.year,
        type = this.type,
        country = this.country.firstOrNull()?.name ?: "",
        category = this.category.map { it.name }
    )
}
