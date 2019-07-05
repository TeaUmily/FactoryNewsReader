package com.example.app_home.common.rest_interface

import com.example.app_single.common.data_models.SingleResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface SingleRestInterface {

    @GET("/v1/articles?source=bbc-news&sortBy=top&apiKey=6946d0c07a1c4555a4186bfcade76398")
    fun getNews () : Observable<SingleResponse>

}