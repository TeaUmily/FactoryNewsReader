package com.example.app_home.news.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.app_home.R
import kotlinx.android.synthetic.main.fragment_bottom_nav.*

class NavigationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_bottom_nav, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabs.setupWithViewPager(homeViewPager)
        homeViewPager.adapter = HomeViewPagerAdapter(childFragmentManager, 2)

        tabs.getTabAt(0)!!.setText(R.string.news)
        tabs.getTabAt(1)!!.setText(R.string.deleted)

    }

    override fun onResume() {
        super.onResume()
        activity!!.title = getString(R.string.app_name)
    }
}

class HomeViewPagerAdapter(fm: FragmentManager, private val size: Int) : FragmentStatePagerAdapter(fm) {


    override fun getCount() = size

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> NewsFragment("news")
            1 -> NewsFragment("deleted")
            else -> NewsFragment("news")
        }
    }
}
