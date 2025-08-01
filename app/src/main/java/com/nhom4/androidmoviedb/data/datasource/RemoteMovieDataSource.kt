package com.nhom4.androidmoviedb.data.datasource

import com.nhom4.androidmoviedb.core.network.ApiHelper
import com.nhom4.androidmoviedb.data.model.MovieResponseDto
import com.nhom4.androidmoviedb.data.parse.parseMovieResponseDto
import com.nhom4.androidmoviedb.data.service.MovieApiService

class RemoteMovieDataSource : MovieApiService {
    override fun getMovies(callback: ApiHelper.Callback<MovieResponseDto>) {
        ApiHelper.fetchObjectAsync(
            urlString = "https://phimapi.com/danh-sach/phim-moi-cap-nhat-v3",
            parse = { json -> parseMovieResponseDto(json) },
            callback = callback
        )
    }
}
