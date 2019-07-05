package com.example.app_common.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(getLayoutResources())
        initUi()

    }

    abstract fun getLayoutResources(): Int
    abstract fun initUi()


}