package by.dzrvnsk.smartcountries.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import by.dzrvnsk.smartcountries.MainActivity
import by.dzrvnsk.smartcountries.R
import kotlin.random.Random

@JvmField
val NOTIFICATION_CHANNEL_NAME: CharSequence = "Periodical reminder"
const val NOTIFICATION_CHANNEL_DESCRIPTION =
    "Shows periodical notifications with invitation to test your knowledge about countries"

@JvmField
val NOTIFICATION_TITLE: CharSequence = "Let's test your knowledge about countries!"
const val CHANNEL_ID = "REMINDER_NOTIFICATION"
const val NOTIFICATION_ID = 1

fun makeStatusNotification(message: String, context: Context) {

    // Make a channel if necessary
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        val name = NOTIFICATION_CHANNEL_NAME
        val description = NOTIFICATION_CHANNEL_DESCRIPTION
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(CHANNEL_ID, name, importance)
        channel.description = description

        // Add the channel
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

        notificationManager?.createNotificationChannel(channel)
    }

    val intent = Intent(context, MainActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    val pendingIntent = PendingIntent.getActivity(context, Random.nextInt(), intent, 0)

    // Create the notification
    val notification = NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle(NOTIFICATION_TITLE)
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setVibrate(LongArray(0))
        .setAutoCancel(true)
        .setContentIntent(pendingIntent)

    // Show the notification
    NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, notification.build())
}