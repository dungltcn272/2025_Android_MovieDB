package com.nhom4.androidmoviedb.data.repository

import com.nhom4.androidmoviedb.data.api.fetchMoviesByTypeList
import com.nhom4.androidmoviedb.data.api.fetchTrendingMovies
import com.nhom4.androidmoviedb.domain.model.MoviePageResult
import com.nhom4.androidmoviedb.domain.repository.MovieRepository

class MovieRepositoryImpl : MovieRepository {
    override fun getTrendingMovies(page: Int, callback: (Result<MoviePageResult>) -> Unit) {
        fetchTrendingMovies(page, callback)
    }

    override fun getMoviesByTypeList(typeList: String, page: Int, callback: (Result<MoviePageResult>) -> Unit) {
        fetchMoviesByTypeList(typeList, page, callback)
    }
}
