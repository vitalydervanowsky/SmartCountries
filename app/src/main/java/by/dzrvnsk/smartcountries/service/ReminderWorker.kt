package by.dzrvnsk.smartcountries.service

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class ReminderWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        return try {
            makeStatusNotification(
                "Tap to open SmartCountries and start testing",
                applicationContext
            )
            Result.success()
        } catch (throwable: Throwable) {
            Result.failure()
        }
    }
}