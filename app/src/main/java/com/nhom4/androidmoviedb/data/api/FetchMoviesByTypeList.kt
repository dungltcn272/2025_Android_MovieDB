package com.nhom4.androidmoviedb.data.api

import com.nhom4.androidmoviedb.core.network.ApiHelper
import com.nhom4.androidmoviedb.core.utils.Constants
import com.nhom4.androidmoviedb.data.mapper.toMovie
import com.nhom4.androidmoviedb.data.model.MovieResponseDto
import com.nhom4.androidmoviedb.data.parse.parseTypeListMovieResponseDto
import com.nhom4.androidmoviedb.domain.model.MoviePageResult

fun fetchMoviesByTypeList(
    typeList: String,
    page: Int,
    callback: (Result<MoviePageResult>) -> Unit
) {
    val url = "${Constants.BASE_URL}/v1/api/danh-sach/$typeList?page=$page"
    ApiHelper.fetchObjectAsync(
        urlString = url,
        parse = { json ->
            parseTypeListMovieResponseDto(json)
        },
        callback = object : ApiHelper.Callback<MovieResponseDto> {
            override fun onSuccess(data: MovieResponseDto) {
                val movies = data.items.map { it.toMovie(false) }
                val totalPages = data.totalPages ?: 1
                callback(Result.success(MoviePageResult(movies, page, totalPages)))
            }

            override fun onError(message: String, code: Int?) {
                callback(Result.failure(Throwable(message)))
            }
        }
    )
}
