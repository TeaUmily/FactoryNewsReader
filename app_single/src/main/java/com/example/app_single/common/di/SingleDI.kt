package com.example.app_single.common.di


import com.example.app_home.common.interactor.SingleInteractor
import com.example.app_home.common.rest_interface.SingleRestInterface
import com.example.app_single.view_model.SingleVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val singleModule = module{
    factory { provideMealRestInterface(get()) }
    factory { SingleInteractor(get()) }
    viewModel { SingleVM(get()) }

}

private fun provideMealRestInterface(retrofit: Retrofit): SingleRestInterface = retrofit.create(SingleRestInterface::class.java)
