package by.dzrvnsk.smartcountries.service

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import by.dzrvnsk.smartcountries.R

class ReminderWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        return try {
            val message = applicationContext.getString(R.string.notification_message)
            makeStatusNotification(message, applicationContext)
            Result.success()
        } catch (throwable: Throwable) {
            Result.failure()
        }
    }
}