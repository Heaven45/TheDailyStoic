package com.example.thedailystoic

import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    private var notificationManager: NotificationManagerCompat? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notificationManager = NotificationManagerCompat.from(this)
    }

    fun onClickOpenPageActivity(view: View?) {
        val intent = Intent(this, PageActivity::class.java)
        startActivity(intent)
    }

    fun onClickOpenSettingsActivity(view: View?) {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    fun onClickSendNotification(view: View?) {
        val title = "Quote of the day"
        val activityIntent = Intent(this, PageActivity::class.java)
        val contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0)
        val notification = NotificationCompat.Builder(this, App.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_message)
                .setContentTitle(title)
                .setContentText(getString(R.string.quote))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .build()
        notificationManager!!.notify(1, notification)
    }
}