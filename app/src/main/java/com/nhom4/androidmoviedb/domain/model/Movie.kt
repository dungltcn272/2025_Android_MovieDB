package com.nhom4.androidmoviedb.domain.model

data class Movie(
    val id: String,
    val title: String,
    val originName: String,
    val thumbUrl: String,
    val posterUrl: String,
    val year: Int,
    val type: String,
    val episodeCurrent: String,
    val quality: String,
    val lang: String,
    val time: String,
    val country: List<String>,
    val category: List<String>,
    val voteAverage: Double?,
    val voteCount: Int?
)
