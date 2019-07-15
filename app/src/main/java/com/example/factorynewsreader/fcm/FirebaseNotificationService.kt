package com.example.factorynewsreader.fcm


import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import com.example.factorynewsreader.R
import com.example.factorynewsreader.activity.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


const val NOTIFICATION_ID = 1001

class FirebaseNotificationService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage?) {
        val channelID = "${baseContext.packageName}-${baseContext.getString(R.string.app_name)}"
        val text = message?.data?.get("body")
        val title = message?.data?.get("title")
        val builder = NotificationCompat.Builder(baseContext, channelID).apply {
            setSmallIcon(R.drawable.ic_notifications)
            setContentText(text)
            setContentTitle(title)
            setAutoCancel(true)
            setContentIntent(createPendingIntent(message?.data?.get("articleID")))
        }

        NotificationManagerCompat.from(baseContext).notify(NOTIFICATION_ID, builder.build())

    }

    private fun createPendingIntent(articleId: String?): PendingIntent {
         val arguments = Bundle().apply {
             putInt("EXTRA_POSITION", articleId!!.toInt())
             putBoolean("from notification", true)
         }
          return NavDeepLinkBuilder(baseContext).setGraph(R.navigation.single_feature_graph)
               .setDestination(R.id.singleMainFragment)
               .setArguments(arguments)
               .createPendingIntent()
    }

    override fun onNewToken(token: String?) {
        Log.d("TOKEN", "Refreshed token: $token")
    }


}