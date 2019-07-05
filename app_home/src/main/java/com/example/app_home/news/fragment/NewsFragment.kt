package com.example.app_home.news.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.airbnb.epoxy.TypedEpoxyController
import com.example.app_common.base.fragment.BaseFragment
import com.example.app_home.R
import com.example.app_home.news.view_holder.newsItemHolder
import com.example.app_home.view_model.NewsUI
import com.example.app_home.view_model.NewsVM
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


open class NewsFragment : BaseFragment<NewsVM>(), ArticleClick {

    companion object{
        const val EXTRA_CLICK_POSITION = "EXTRA_POSITION"
    }

    private val newsController by inject<NewsController>{parametersOf(this)}
    override val viewModel: NewsVM by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsRecyclerView.setController(newsController)

    }

    override fun getLayoutResources() = R.layout.fragment_news

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initObservers()

    }

    private fun initObservers() {
        viewModel.newsData.observe(viewLifecycleOwner, Observer { data ->
            data?.let {
                newsController.setData(it)
            }
        })
    }

    override fun onArticleClick(position: Int) {
        val bundle = Bundle()
        bundle.putInt(EXTRA_CLICK_POSITION, position)
        findNavController().navigate(R.id.openSingleFeatureAction, bundle)
    }

}


interface ArticleClick {
    fun onArticleClick(position: Int)
}


class NewsController(private val listener: ArticleClick) : TypedEpoxyController<NewsUI>() {

    override fun buildModels(data: NewsUI) {
        var i: Long = 0
        data.data.forEach { newsCell ->
            newsItemHolder {
                id(i++)
                image(newsCell.image)
                description(newsCell.description)
                clickListener{ _, _, _, position ->
                    listener.onArticleClick(position)
                }
            }
        }
    }

}
