package com.nhom4.androidmoviedb.data.model

data class MovieResponseDto(
    val status: Boolean,
    val msg: String,
    val items: List<MovieItemDto>,
    val totalPages: Int? = null
)
