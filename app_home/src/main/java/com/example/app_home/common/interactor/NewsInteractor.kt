package com.example.app_home.common.interactor

import com.example.app_common.utils.ptSchedulers
import com.example.app_home.common.rest_interface.NewsRestInterface


class NewsInteractor(private val restInterface: NewsRestInterface) {


    fun getNews() = restInterface.getNews().ptSchedulers()

}


