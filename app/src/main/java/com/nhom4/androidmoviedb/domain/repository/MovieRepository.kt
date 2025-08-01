package com.nhom4.androidmoviedb.domain.repository

import com.nhom4.androidmoviedb.domain.model.Movie

interface MovieRepository {
    fun getNewMovies(page: Int, callback: (Result<List<Movie>>) -> Unit)
}
