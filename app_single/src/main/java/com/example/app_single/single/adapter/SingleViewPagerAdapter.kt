package com.example.app_single.single.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.app_single.single.fragments.SingleArticleFragment

class SingleViewPagerAdapter(fm: FragmentManager, private val size: Int) : FragmentStatePagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return SingleArticleFragment.newInstance(position)
    }

    override fun getCount() = size

}