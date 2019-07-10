package com.example.app_home.news.fragment

import com.example.app_common.base.fragment.BaseFragment
import com.example.app_home.R
import com.example.app_home.view_model.NewsVM
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MoreNewsFragment : BaseFragment<NewsVM>() {


    override val viewModel: NewsVM by sharedViewModel()

    override fun getLayoutResources() = R.layout.fragment_more_news

}