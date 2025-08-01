package com.nhom4.androidmoviedb.presentation.base

import com.nhom4.androidmoviedb.domain.model.Movie
import com.nhom4.androidmoviedb.domain.usecase.GetNewMoviesUseCase

interface BasePresenter<V : BaseView> {
    fun attachView(view: V)
    fun detachView()
}

// Usage example:
interface MovieListView : BaseView {
    fun showMovies(movies: List<Movie>)
}

class MovieListPresenter(
    private val getNewMoviesUseCase: GetNewMoviesUseCase
) : BasePresenter<MovieListView> {

    private var view: MovieListView? = null

    override fun attachView(view: MovieListView) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    fun loadNewMovies(page: Int) {
        view?.showLoading(true)
        getNewMoviesUseCase.execute(page) { result ->
            view?.showLoading(false)
            result.onSuccess {
                view?.showMovies(it)
            }.onFailure {
                view?.showError(it.message ?: "Unknown error")
            }
        }
    }
}
