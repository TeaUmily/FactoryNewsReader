package com.example.app_common.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.app_common.base.view_model.BaseViewModel


abstract class BaseFragment<T : BaseViewModel> : Fragment() {


    abstract val viewModel: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(getLayoutResources(), container, false)

    abstract fun getLayoutResources(): Int

}