package com.example.app_home.news.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.app_common.base.fragment.BaseFragment
import com.example.app_home.R
import com.example.app_home.view_model.NewsVM
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.core.parameter.parametersOf

class DeletedNewsFragment : BaseFragment<NewsVM>(), ArticleClick {

    private val newsController by inject<NewsController> { parametersOf(this) }
    override val viewModel: NewsVM by sharedViewModel()

    override fun getLayoutResources() = R.layout.fragment_news


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsRecyclerView.setController(newsController)
        initObservers()
    }

    override fun onDelete(position: Int) {
    }

    override fun onTextClick(position: Int) {
    }

    private fun initObservers() {
        viewModel.newsData.observe(viewLifecycleOwner, Observer { data ->
            data?.let {
                newsController.setData(viewModel.getDeletedNews())
            }
        })
    }
}

