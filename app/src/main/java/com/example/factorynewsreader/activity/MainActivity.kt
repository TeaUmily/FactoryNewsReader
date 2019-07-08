package com.example.factorynewsreader.activity

import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.app_common.base.activity.BaseActivity
import com.example.factorynewsreader.R

class MainActivity : BaseActivity() {


    override fun getLayoutResources() = R.layout.activity_main

    override fun onSupportNavigateUp() = Navigation.findNavController(findViewById(R.id.homeNavigationFragment)).navigateUp()

    override fun initUi() {
        //supportFragmentManager.beginTransaction().add(R.id.container, SingleMainFragment()).commit()
        setupNavigation()
    }


    private fun setupNavigation() {
        val navController = Navigation.findNavController(findViewById(R.id.homeNavigationFragment))
        NavigationUI.setupActionBarWithNavController(this@MainActivity, navController)
    }
}



