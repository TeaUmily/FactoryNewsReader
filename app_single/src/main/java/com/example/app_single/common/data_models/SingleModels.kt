package com.example.app_single.common.data_models

data class SingleResponse(val articles: List<News>)

data class News(
    val publishedAt: String,
    val author: String,
    val urlToImage: String,
    val description: String,
    val title: String,
    val url: String
)
