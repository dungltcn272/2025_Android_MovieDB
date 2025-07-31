package com.nhom4.androidmoviedb.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nhom4.androidmoviedb.core.platform.BaseFragment
import com.nhom4.androidmoviedb.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        // Setup adapter, recyclerView...
    }

    override fun initData() {
        // Gọi API, load dữ liệu...
    }
}
