package com.example.factorynewsreader

import com.example.app_common.BaseApp
import com.example.app_common.dependency_injection.networkingModule
import com.example.app_home.common.di.newsModule
import com.example.app_single.common.di.singleModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : BaseApp() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    networkingModule,
                    newsModule,
                    singleModule
                )
            )
        }

    }


}