package com.example.app_single.view_model

import androidx.lifecycle.MutableLiveData
import com.example.app_common.base.view_model.BaseViewModel
import com.example.app_home.common.interactor.SingleInteractor
import java.util.Locale.filter

class SingleVM(private val interactor: SingleInteractor) : BaseViewModel() {


    val singleData = MutableLiveData<SingleUI>()

    var position : Int = 0

    init {
        singleData.value = null

        loadNews()
    }

     fun loadNews() {
        interactor.getNews().map { response ->
            provideSingleUI(response)
        }.doOnNext {
            singleData.value = it
        }.ptSubscribe()
    }


    fun getArticle(position: Int): SingleItem {
        return singleData.value!!.data[position]
    }

    fun getPosition(id: Int): Int{
        // ovdje se treba prema IDu pronaci article i vratiti njegovu poziciju
        return id
    }

    fun getTitle() : String{
        return singleData.value!!.data[position].title
    }


    fun getMoreInfo() :  MoreInfoItem {
        return provideMoreInfo(singleData.value!!.data[position])
    }


}