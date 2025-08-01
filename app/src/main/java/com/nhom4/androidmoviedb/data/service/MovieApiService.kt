package com.nhom4.androidmoviedb.data.service

import com.nhom4.androidmoviedb.core.network.ApiHelper
import com.nhom4.androidmoviedb.data.model.MovieResponseDto

interface MovieApiService {
    fun getMovies(callback: ApiHelper.Callback<MovieResponseDto>)
}
