package com.example.app_home.view_model

import com.example.app_home.common.data_models.NewsResponse


data class NewsUI (val data: MutableList<NewsCell>)
data class NewsCell (val description: String, val image: String, var deleted : Boolean)


fun provideNewsUI(response: NewsResponse) : NewsUI {
    return NewsUI(response.articles.map { NewsCell(it.description, it.urlToImage, false) }.toMutableList())
}