package com.nhom4.androidmoviedb.data.mapper

import com.nhom4.androidmoviedb.core.utils.Constants
import com.nhom4.androidmoviedb.data.model.MovieItemDto
import com.nhom4.androidmoviedb.domain.model.Movie

fun MovieItemDto.toMovie(hasDomainIMG: Boolean = true): Movie {
    return Movie(
        id = this._id,
        title = this.name,
        originName = this.origin_name,
        thumbUrl = if (hasDomainIMG) this.thumb_url else "${Constants.APP_DOMAIN_CDN_IMAGE}/${this.thumb_url}",
        posterUrl = if (hasDomainIMG) this.poster_url else "${Constants.APP_DOMAIN_CDN_IMAGE}/${this.poster_url}",
        year = this.year,
        type = this.type,
        episodeCurrent = this.episode_current,
        quality = this.quality,
        lang = this.lang,
        time = this.time,
        country = this.country.map { it.name },
        category = this.category.map { it.name },
        voteAverage = this.tmdb.vote_average,
        voteCount = this.tmdb.vote_count
    )
}
