package com.nhom4.androidmoviedb.presentation

import com.nhom4.androidmoviedb.core.platform.BaseActivity
import com.nhom4.androidmoviedb.data.repository.MovieRepositoryImpl
import com.nhom4.androidmoviedb.databinding.ActivityMainBinding
import com.nhom4.androidmoviedb.domain.model.Movie
import com.nhom4.androidmoviedb.domain.usecase.GetNewMoviesUseCase
import com.nhom4.androidmoviedb.presentation.base.MovieListPresenter
import com.nhom4.androidmoviedb.presentation.base.MovieListView

class MainActivity : BaseActivity<ActivityMainBinding>(), MovieListView {

    private lateinit var presenter: MovieListPresenter

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        val repository = MovieRepositoryImpl()
        val useCase = GetNewMoviesUseCase(repository)
        presenter = MovieListPresenter(useCase)

        presenter.attachView(this)

        presenter.loadNewMovies(1)
        // setup NavController...
    }

    override fun showMovies(movies: List<Movie>) {
        binding.txt.text = "Movies loaded: $movies"
    }

    override fun showLoading(isLoading: Boolean) {
        if (isLoading) binding.txt.text = "Loading movies..."
    }

    override fun showError(message: String) {
        binding.txt.text = "Error: $message"
    }
}
