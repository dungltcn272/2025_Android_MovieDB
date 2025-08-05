package com.nhom4.androidmoviedb

import android.app.Application
import android.util.Log
import com.nhom4.androidmoviedb.data.repository.MovieRepositoryImpl
import com.nhom4.androidmoviedb.domain.usecase.GetMoviesByTypeListUseCase
import com.nhom4.androidmoviedb.domain.usecase.GetTrendingMoviesUseCase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val getTrendingMoviesUseCase = GetTrendingMoviesUseCase(MovieRepositoryImpl())
        // Example usage of the use case
        getTrendingMoviesUseCase.execute(1) { result ->
            result.onSuccess { movies ->
                Log.d("vsssvvs", "Trending: ${movies.totalPages} pages, ${movies.movies.size} movies, ${movies.currentPage}")
                Log.d("vsssvvs", "First: ${movies.movies.firstOrNull()}")
            }.onFailure {
                Log.e("vsssvvs", "Error fetching trending movies: ${it.message}")
            }
        }

        val getMoviesByTypeListUseCase = GetMoviesByTypeListUseCase(MovieRepositoryImpl())
        // Example usage of the use case
        getMoviesByTypeListUseCase.execute("phim-bo", 1) { result ->
            result.onSuccess { movies ->
                Log.d("vsssvvs", "TypeList: ${movies.totalPages} pages, ${movies.movies.size} movies, ${movies.currentPage}")
                Log.d("vsssvvs", "First: ${movies.movies.firstOrNull()}")
            }.onFailure {
                Log.e("vsssvvs", "Error fetching movies by type list: ${it.message}")
            }
        }
    }
}
