package com.example.app_home.view_model

import androidx.lifecycle.MutableLiveData
import com.example.app_common.base.view_model.BaseViewModel
import com.example.app_home.common.interactor.NewsInteractor

class NewsVM(private val interactor: NewsInteractor) : BaseViewModel() {

    val newsData = MutableLiveData<NewsUI>()


    init {
        newsData.value = null

        loadNews()
    }

    private fun loadNews() {
        interactor.getNews().map { response ->
            provideNewsUI(response)
        }.doOnNext {
            newsData.value = it
        }.ptSubscribe()
    }

    fun getNews(): NewsUI {
        return NewsUI(newsData.value!!.data.filter { newsCell -> !newsCell.deleted}.toMutableList())
    }

    fun getDeletedNews(): NewsUI {
        return NewsUI(newsData.value!!.data.filter { newsCell -> newsCell.deleted }.toMutableList())
    }

    fun deleteArticle(position: Int) {
        newsData.value!!.data[position].deleted = true
        newsData.value = newsData.value
    }

}