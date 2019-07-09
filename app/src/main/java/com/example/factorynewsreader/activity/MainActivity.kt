package com.example.factorynewsreader.activity

import android.util.Log
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.app_common.base.activity.BaseActivity
import com.example.factorynewsreader.R
import com.google.firebase.FirebaseApp
import com.google.firebase.iid.FirebaseInstanceId

class MainActivity : BaseActivity() {


    override fun getLayoutResources() = R.layout.activity_main

    override fun onSupportNavigateUp() =
        Navigation.findNavController(findViewById(R.id.homeNavigationFragment)).navigateUp()

    override fun initUi() {
        setupNavigation()


        FirebaseApp.initializeApp(this)
        FirebaseInstanceId.getInstance().instanceId
            .addOnSuccessListener(this) { instanceIdResult ->
                val newToken = instanceIdResult.token
                Log.e("newToken", newToken)
            }
    }

    private fun setupNavigation() {
        val navController = Navigation.findNavController(findViewById(R.id.homeNavigationFragment))
        NavigationUI.setupActionBarWithNavController(this@MainActivity, navController)
    }
}



