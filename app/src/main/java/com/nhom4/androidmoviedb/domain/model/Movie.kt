package com.nhom4.androidmoviedb.domain.model

data class Movie(
    val id: String,
    val title: String,
    val thumbUrl: String,
    val year: Int,
    val type: String,
    val country: String,
    val category: List<String>
)
