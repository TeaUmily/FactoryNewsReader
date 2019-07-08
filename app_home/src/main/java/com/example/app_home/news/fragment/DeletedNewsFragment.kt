package com.example.app_home.news.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.airbnb.epoxy.TypedEpoxyController
import com.example.app_common.base.fragment.BaseFragment
import com.example.app_home.R
import com.example.app_home.news.view_holder.deletedNewsItemHolder
import com.example.app_home.view_model.NewsUI
import com.example.app_home.view_model.NewsVM
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.core.parameter.parametersOf

class DeletedNewsFragment : BaseFragment<NewsVM>() {

    private val deletedNewsController by inject<DeletedNewsController> ()
    override val viewModel: NewsVM by sharedViewModel()


    override fun getLayoutResources() = R.layout.fragment_news


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsRecyclerView.setController(deletedNewsController)

        initObservers()
    }

    private fun initObservers() {
        viewModel.deletedNewsList.observe(viewLifecycleOwner, Observer { data ->
            data?.let {
                deletedNewsController.setData(it)
            }
        })
    }
}

class DeletedNewsController : TypedEpoxyController<NewsUI>() {

    override fun buildModels(data: NewsUI) {
        var i: Long = 0
        data.data.forEach { newsCell ->
            deletedNewsItemHolder {
                id(i++)
                image(newsCell.image)
                description(newsCell.description)
            }
        }
    }
}

