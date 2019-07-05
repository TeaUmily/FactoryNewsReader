package com.example.app_single.view_model

import com.example.app_single.common.data_models.SingleResponse

data class SingleUI(val data: MutableList<SingleItem>)
data class SingleItem(
    val title: String,
    val description: String,
    val image: String,
    val publishedAt: String,
    val author: String
)

data class MoreInfoItem(val author: String, val publishedAt: String)

fun provideSingleUI(response: SingleResponse): SingleUI {
    return SingleUI(response.articles.map {
        SingleItem(
            it.title,
            it.description,
            it.urlToImage,
            it.publishedAt,
            it.author
        )
    }.toMutableList())
}

fun provideMoreInfo(singleItem: SingleItem): MoreInfoItem {
    return MoreInfoItem(singleItem.author, singleItem.publishedAt)
}
