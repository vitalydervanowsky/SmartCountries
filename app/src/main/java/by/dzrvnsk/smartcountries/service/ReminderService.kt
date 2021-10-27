package by.dzrvnsk.smartcountries.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

const val WORK_TAG = "PERIODIC_REMINDER"

class ReminderService : Service() {
    private var periodicWorkRequest: PeriodicWorkRequest? = null
    private val binder: IBinder = LocalBinder()

    override fun onBind(intent: Intent?): IBinder {
        periodicWorkRequest = PeriodicWorkRequest
            .Builder(ReminderWorker::class.java, 2, TimeUnit.HOURS)
            .addTag(WORK_TAG)
            .build()
        return binder
    }

    fun start() {
        periodicWorkRequest?.let { WorkManager.getInstance(this).enqueue(it) }
    }

    fun stop() {
        WorkManager.getInstance(this).cancelAllWorkByTag(WORK_TAG)
    }

    inner class LocalBinder : Binder() {
        fun getReminderServiceInstance(): ReminderService {
            return this@ReminderService
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        periodicWorkRequest = null
    }
}