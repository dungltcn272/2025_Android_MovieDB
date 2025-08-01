package com.nhom4.androidmoviedb.domain.usecase

import com.nhom4.androidmoviedb.domain.model.Movie
import com.nhom4.androidmoviedb.domain.repository.MovieRepository

class GetNewMoviesUseCase(private val repo: MovieRepository) {
    fun execute(page: Int, callback: (Result<List<Movie>>) -> Unit) {
        repo.getNewMovies(page, callback)
    }
}
