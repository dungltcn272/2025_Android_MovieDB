package com.nhom4.androidmoviedb.domain.usecase

import com.nhom4.androidmoviedb.domain.model.MoviePageResult
import com.nhom4.androidmoviedb.domain.repository.MovieRepository

class GetTrendingMoviesUseCase(private val repo: MovieRepository) {
    fun execute(page: Int, callback: (Result<MoviePageResult>) -> Unit) {
        repo.getTrendingMovies(page, callback)
    }
}
