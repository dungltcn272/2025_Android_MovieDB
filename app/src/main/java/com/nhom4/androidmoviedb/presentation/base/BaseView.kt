package com.nhom4.androidmoviedb.presentation.base

interface BaseView {
    fun showLoading(isLoading: Boolean)
    fun showError(message: String)
}
