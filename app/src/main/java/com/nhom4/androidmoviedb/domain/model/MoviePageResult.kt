package com.nhom4.androidmoviedb.domain.model

data class MoviePageResult(
    val movies: List<Movie>,
    val currentPage: Int,
    val totalPages: Int
)
