package com.nhom4.androidmoviedb.presentation.base

interface BasePresenter<V : BaseView> {
    fun attachView(view: V)
    fun detachView()
}

// Usage example:
// interface MovieListView : BaseView {
//    fun showMovies(movies: List<Movie>)
// }
//
// class MovieListPresenter : BasePresenter<MovieListView> {
//
//    private var view: MovieListView? = null
//    private val movieRepository = MovieRepository() // ví dụ dùng Retrofit
//
//    override fun attachView(view: MovieListView) {
//        this.view = view
//    }
//
//    override fun detachView() {
//        this.view = null
//    }
//
//    fun fetchMovies() {
//        view?.showLoading(true)
//        movieRepository.getMovies(
//            onSuccess = { movies ->
//                view?.showLoading(false)
//                view?.showMovies(movies)
//            },
//            onError = { error ->
//                view?.showLoading(false)
//                view?.showError(error)
//            }
//        )
//    }
// }
