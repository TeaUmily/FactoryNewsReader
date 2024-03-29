package com.example.app_home.news.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.airbnb.epoxy.TypedEpoxyController
import com.example.app_common.base.fragment.BaseFragment
import com.example.app_home.R

import com.example.app_home.news.view_holder.newsItemHolder
import com.example.app_home.view_model.NewsUI
import com.example.app_home.view_model.NewsVM
import kotlinx.android.synthetic.main.fragment_bottom_nav.*
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

import org.koin.core.parameter.parametersOf


const val EXTRA_CLICK_POSITION = "EXTRA_POSITION"

open class NewsFragment : BaseFragment<NewsVM>(), ArticleClick {

    private val newsController by inject<NewsController> { parametersOf(this) }
    override val viewModel: NewsVM by sharedViewModel()
    var isClickedOnText = false


    override fun onResume() {
        super.onResume()
        viewModel.hideToolbar.value = false
        activity!!.title  = getString(R.string.app_name)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsRecyclerView.setController(newsController)
        newsRecyclerView.setRemoveAdapterWhenDetachedFromWindow(true)
        initObservers()
    }

    override fun getLayoutResources() = R.layout.fragment_news

    private fun initObservers() {
        viewModel.newsData.observe(viewLifecycleOwner, Observer { data ->
            data?.let {
                newsController.setData(viewModel.getNews())
            }
        })
    }

    override fun onTextClick(position: Int) {
        val bundle = Bundle()
        bundle.putInt(EXTRA_CLICK_POSITION, position)
        isClickedOnText = true
        activity!!.findNavController(R.id.navigationItemsContainer).navigate(R.id.openSingleFeatureAction, bundle)
    }

    override fun onDelete(description: String) {
        viewModel.deleteArticle(description)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (isClickedOnText) {
            viewModel.hideToolbar.value = true
            isClickedOnText = false
        }
    }
}

interface ArticleClick {
    fun onTextClick(position: Int)
    fun onDelete(description: String)
}

class NewsController(private val listener: ArticleClick) : TypedEpoxyController<NewsUI>() {

    override fun buildModels(data: NewsUI) {
        var i: Long = 0
        data.data.forEachIndexed { _, newsCell ->
            newsItemHolder {
                id(i++)
                image(newsCell.image)
                description(newsCell.description)
                notDeleted(!newsCell.deleted)
                clickListener { _, _, clickedView, position ->
                    when (clickedView.id) {
                        R.id.tvDescription -> listener.onTextClick(position)
                        R.id.deleteBtn -> listener.onDelete(newsCell.description)
                    }
                }
            }
        }
    }
}
