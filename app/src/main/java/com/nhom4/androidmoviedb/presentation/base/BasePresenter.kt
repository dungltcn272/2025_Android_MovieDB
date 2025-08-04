package com.nhom4.androidmoviedb.presentation.base

interface BasePresenter<V : BaseView> {
    fun attachView(view: V)
    fun detachView()
}
