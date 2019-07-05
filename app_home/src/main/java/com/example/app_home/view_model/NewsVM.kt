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


}