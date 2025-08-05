package com.nhom4.androidmoviedb.data.model

data class MovieItemDto(
    val tmdb: TmdbInfoDto,
    val imdb: ImdbInfoDto,
    val modified: ModifiedInfoDto,
    val _id: String,
    val name: String,
    val slug: String,
    val origin_name: String,
    val type: String,
    val poster_url: String,
    val thumb_url: String,
    val sub_docquyen: Boolean,
    val chieurap: Boolean? = null,
    val time: String,
    val episode_current: String,
    val quality: String,
    val lang: String,
    val year: Int,
    val category: List<CategoryDto>,
    val country: List<CountryDto>
)
