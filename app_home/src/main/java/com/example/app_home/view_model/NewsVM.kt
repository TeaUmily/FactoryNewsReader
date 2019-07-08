package com.example.app_home.view_model

import androidx.lifecycle.MutableLiveData
import com.example.app_common.base.view_model.BaseViewModel
import com.example.app_home.common.interactor.NewsInteractor

class NewsVM(private val interactor: NewsInteractor) : BaseViewModel() {

    val newsData = MutableLiveData<NewsUI>()
    val deletedNewsList = MutableLiveData<NewsUI>()

    init {
        newsData.value = null
        deletedNewsList.value = NewsUI(mutableListOf())

        loadNews()
    }

    private fun loadNews() {
        interactor.getNews().map { response ->
            provideNewsUI(response)
        }.doOnNext {
            newsData.value = it
        }.ptSubscribe()
    }

    fun deleteArticle(position: Int) {
        val temp = newsData.value!!.data[position]

        deletedNewsList.value!!.data.add(temp)
        deletedNewsList.value = deletedNewsList.value

        newsData.value!!.data.removeAt(position)
        newsData.value = newsData.value
    }

}