package com.nhom4.androidmoviedb.domain.usecase

import com.nhom4.androidmoviedb.domain.model.MoviePageResult
import com.nhom4.androidmoviedb.domain.repository.MovieRepository

class GetMoviesByTypeListUseCase(private val repo: MovieRepository) {
    fun execute(typeList: String, page: Int, callback: (Result<MoviePageResult>) -> Unit) {
        repo.getMoviesByTypeList(typeList, page, callback)
    }
}
