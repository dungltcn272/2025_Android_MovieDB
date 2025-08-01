package com.nhom4.androidmoviedb.data.repository

import com.nhom4.androidmoviedb.core.network.ApiHelper
import com.nhom4.androidmoviedb.data.mapper.toMovie
import com.nhom4.androidmoviedb.data.model.MovieResponseDto
import com.nhom4.androidmoviedb.data.parse.parseMovieResponseDto
import com.nhom4.androidmoviedb.domain.model.Movie
import com.nhom4.androidmoviedb.domain.repository.MovieRepository

class MovieRepositoryImpl : MovieRepository {
    override fun getNewMovies(page: Int, callback: (Result<List<Movie>>) -> Unit) {
        val url = "https://phimapi.com/danh-sach/phim-moi-cap-nhat-v3?page=$page"

        ApiHelper.fetchObjectAsync(
            urlString = url,
            parse = { json ->
                parseMovieResponseDto(json)
            },
            callback = object : ApiHelper.Callback<MovieResponseDto> {
                override fun onSuccess(data: MovieResponseDto) {
                    val movies = data.items.map { it.toMovie() }
                    callback(Result.success(movies))
                }

                override fun onError(message: String, code: Int?) {
                    callback(Result.failure(Throwable(message)))
                }
            }
        )
    }
}
