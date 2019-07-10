package com.example.app_home.common.di

import com.example.app_home.common.interactor.NewsInteractor
import com.example.app_home.common.rest_interface.NewsRestInterface
import com.example.app_home.news.fragment.*
import com.example.app_home.view_model.NewsVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val newsModule = module {
    factory { provideMealRestInterface(get()) }
    factory { NewsInteractor(get()) }
    viewModel { NewsVM(get()) }

    factory { (currentTab: String, listener: ArticleClick) -> NewsController(listener, currentTab) }
}

private fun provideMealRestInterface(retrofit: Retrofit): NewsRestInterface =
    retrofit.create(NewsRestInterface::class.java)
