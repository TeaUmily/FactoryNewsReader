package com.example.app_single.single.fragments

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.example.app_common.base.fragment.BaseFragment
import com.example.app_single.R
import com.example.app_single.single.adapter.SingleViewPagerAdapter
import com.example.app_single.view_model.SingleVM
import kotlinx.android.synthetic.main.fragment_single_container.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SingleMainFragment : BaseFragment<SingleVM>(), ViewPager.OnPageChangeListener {

    override val viewModel by sharedViewModel<SingleVM>()

    override fun getLayoutResources() = R.layout.fragment_single_container

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val position = arguments!!.getInt("EXTRA_POSITION", 0)
        viewModel.position = position

        initObserver()

    }

    private fun initObserver() {
        viewModel.singleData.observe(viewLifecycleOwner, Observer { data ->
            data?.let {
                if (viewPager.adapter == null) {
                    val adapter = SingleViewPagerAdapter(childFragmentManager, it.data.size)
                    viewPager.adapter = adapter
                    viewPager.currentItem = viewModel.position
                    viewPager.addOnPageChangeListener(this)
                    activity!!.title = viewModel.getTitle()
                }
            }
        })

    }

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        viewModel.position = position
        activity!!.title = viewModel.getTitle()
    }

}