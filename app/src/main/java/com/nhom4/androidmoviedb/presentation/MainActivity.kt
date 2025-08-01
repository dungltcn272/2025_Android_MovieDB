package com.nhom4.androidmoviedb.presentation

import com.nhom4.androidmoviedb.core.platform.BaseActivity
import com.nhom4.androidmoviedb.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {

        // setup NavController...
    }
}
