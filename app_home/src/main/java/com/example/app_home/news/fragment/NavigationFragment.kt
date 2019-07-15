package com.example.app_home.news.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.app_home.R
import com.example.app_home.view_model.NewsVM
import kotlinx.android.synthetic.main.fragment_bottom_nav.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*

class NavigationFragment : Fragment() {

    private val viewModel: NewsVM by sharedViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_bottom_nav, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentNews = NewsFragment()
        val fragmentDeleted = DeletedNewsFragment()
        val fragmentMore = MoreNewsFragment()

        childFragmentManager.beginTransaction()
            .replace(R.id.navigationItemsContainer, fragmentNews, "fragmentNews")
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .addToBackStack(null)
            .commit()

        newsBtn.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.navigationItemsContainer, fragmentNews, "fragmentNews")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit()
        }

        deletedNewsBtn.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.navigationItemsContainer, fragmentDeleted, "fragmentDeleted")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit()
        }

        moreNewsBtn.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.navigationItemsContainer, fragmentMore, "fragmentMore")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit()
        }


        viewModel.hideToolbar.observe(viewLifecycleOwner, Observer { flag ->
            if (flag) {
                customBottomNavigation.visibility = View.GONE
            } else {
                customBottomNavigation.visibility = View.VISIBLE
            }
        })
    }

}

