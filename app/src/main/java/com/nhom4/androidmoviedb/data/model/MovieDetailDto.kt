package com.nhom4.androidmoviedb.data.model

data class MovieDetailResponseDto(
    val status: Boolean,
    val msg: String,
    val movie: MovieDetailDto,
    val episodes: List<EpisodeGroupDto>
)

data class MovieDetailDto(
    val tmdb: TmdbInfoDto,
    val imdb: ImdbInfoDto,
    val created: TimeDto,
    val modified: TimeDto,
    val _id: String,
    val name: String,
    val slug: String,
    val origin_name: String,
    val content: String,
    val type: String,
    val status: String,
    val poster_url: String,
    val thumb_url: String,
    val is_copyright: Boolean,
    val sub_docquyen: Boolean,
    val chieurap: Boolean,
    val trailer_url: String,
    val time: String,
    val episode_current: String,
    val episode_total: String,
    val quality: String,
    val lang: String,
    val notify: String,
    val showtimes: String,
    val year: Int,
    val view: Int,
    val actor: List<String>,
    val director: List<String>,
    val category: List<CategoryDto>,
    val country: List<CountryDto>
)

data class EpisodeGroupDto(
    val server_name: String,
    val server_data: List<EpisodeDto>
)

data class EpisodeDto(
    val name: String,
    val slug: String,
    val filename: String,
    val link_embed: String,
    val link_m3u8: String
)

data class TimeDto(
    val time: String
)
