package com.example.app_home.news.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.airbnb.epoxy.TypedEpoxyController
import com.example.app_common.base.fragment.BaseFragment
import com.example.app_home.R

import com.example.app_home.news.view_holder.newsItemHolder
import com.example.app_home.view_model.NewsCell
import com.example.app_home.view_model.NewsUI
import com.example.app_home.view_model.NewsVM
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

import org.koin.core.parameter.parametersOf




const val EXTRA_CLICK_POSITION = "EXTRA_POSITION"

open class NewsFragment : BaseFragment<NewsVM>(), ArticleClick {

    private val newsController by inject<NewsController> { parametersOf( this ) }
    override val viewModel: NewsVM by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsRecyclerView.setController(newsController)
        initObservers()
        newsController.setData(NewsUI(mutableListOf<NewsCell>(NewsCell("The ambassador steps down after emails criticising President Trump's administration were leaked.","https://ichef.bbci.co.uk/news/1024/branded_news/0179/production/_107777300_366eca34-89b6-46ee-b53e-260f5e6944e5.jpg" ))))

    }

    override fun getLayoutResources() = R.layout.fragment_news

    private fun initObservers() {
        viewModel.newsData.observe(viewLifecycleOwner, Observer { data ->
            data?.let {

                   newsController.setData(it)
            }
        })
    }

    override fun onTextClick(position: Int) {
        val bundle = Bundle()
        bundle.putInt(EXTRA_CLICK_POSITION, position)
        activity!!.findNavController(R.id.newsFragment).navigate(R.id.openSingleFeatureAction, bundle)
    }

    override fun onDelete(position: Int) {
        viewModel.deleteArticle(position)
    }
}

interface ArticleClick {
    fun onTextClick(position: Int)
    fun onDelete(position: Int)
}

class NewsController(private val listener: ArticleClick) : TypedEpoxyController<NewsUI>() {

    override fun buildModels(data: NewsUI) {
        var i: Long = 0
        data.data.forEach { newsCell ->
            newsItemHolder {
                id(i++)
                image(newsCell.image)
                description(newsCell.description)
                clickListener { _, _, clickedView, position ->
                    when (clickedView.id) {
                        R.id.tvDescription -> listener.onTextClick(position)
                        R.id.deleteBtn -> listener.onDelete(position)
                    }
                }
            }
        }
    }
}
