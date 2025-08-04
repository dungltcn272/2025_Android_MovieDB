package com.nhom4.androidmoviedb.presentation.notification

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nhom4.androidmoviedb.core.platform.BaseFragment
import com.nhom4.androidmoviedb.databinding.FragmentNotificationBinding

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        super.initView()
    }

    override fun initData() {
        super.initData()
    }
}
