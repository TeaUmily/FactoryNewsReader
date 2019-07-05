package com.example.app_home.common.interactor

import com.example.app_common.utils.ptSchedulers
import com.example.app_home.common.rest_interface.SingleRestInterface


class SingleInteractor(private val restInterface: SingleRestInterface) {


    fun getNews() = restInterface.getNews().ptSchedulers()

}


