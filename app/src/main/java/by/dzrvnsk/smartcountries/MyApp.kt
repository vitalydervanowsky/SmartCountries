package by.dzrvnsk.smartcountries

import android.app.Application
import android.content.Context

class MyApp : Application() {

    private var context: Context? = null

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    fun getContext(): Context? {
        return context
    }
}