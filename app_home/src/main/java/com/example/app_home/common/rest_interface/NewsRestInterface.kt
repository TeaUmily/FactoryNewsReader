package com.example.app_home.common.rest_interface

import com.example.app_home.common.data_models.NewsResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface NewsRestInterface {

    @GET("/v1/articles?source=bbc-news&sortBy=top&apiKey=6946d0c07a1c4555a4186bfcade76398")
    fun getNews () : Observable<NewsResponse>

}