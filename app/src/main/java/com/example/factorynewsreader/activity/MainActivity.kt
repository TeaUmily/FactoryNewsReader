package com.example.factorynewsreader.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.util.Log
import androidx.core.app.NavUtils
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.app_common.base.activity.BaseActivity
import com.example.factorynewsreader.R
import com.example.factorynewsreader.fcm.createNotificationChannel
import com.google.firebase.FirebaseApp
import com.google.firebase.iid.FirebaseInstanceId


class MainActivity : BaseActivity() {


    override fun getLayoutResources() = R.layout.activity_main

    override fun onSupportNavigateUp() =
        Navigation.findNavController(findViewById(R.id.homeNavigationFragment)).navigateUp()

    override fun initUi() {
        setupNavigation()

        createNotificationChannel(
            baseContext,
            NotificationManagerCompat.IMPORTANCE_DEFAULT,
            false,
            getString(R.string.app_name),
            "App notification channel."
        )

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



