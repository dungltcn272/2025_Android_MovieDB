package com.nhom4.androidmoviedb.data.model

data class MovieResponseDto(
    val status: Boolean,
    val msg: String,
    val items: List<MovieItemDto>
)

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
    val time: String,
    val episode_current: String,
    val quality: String,
    val lang: String,
    val year: Int,
    val category: List<CategoryDto>,
    val country: List<CountryDto>
)

data class TmdbInfoDto(
    val type: String,
    val id: String,
    val season: Int?,
    val vote_average: Double,
    val vote_count: Int
)

data class ImdbInfoDto(
    val id: String?
)

data class ModifiedInfoDto(
    val time: String
)

data class CategoryDto(
    val id: String,
    val name: String,
    val slug: String
)

data class CountryDto(
    val id: String,
    val name: String,
    val slug: String
)
