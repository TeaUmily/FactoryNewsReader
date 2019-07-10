package com.example.app_home.news.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.app_home.R
import kotlinx.android.synthetic.main.fragment_bottom_nav.*


class NavigationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_bottom_nav, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(requireActivity(), R.id.bottomNavigationFragment)
        bottomNavigation.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()
        activity!!.title = getString(R.string.app_name)
    }
}

