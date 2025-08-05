package com.nhom4.androidmoviedb.domain.repository

import com.nhom4.androidmoviedb.domain.model.MoviePageResult

interface MovieRepository {
    fun getTrendingMovies(page: Int, callback: (Result<MoviePageResult>) -> Unit)
    fun getMoviesByTypeList(typeList: String, page: Int, callback: (Result<MoviePageResult>) -> Unit)
}
