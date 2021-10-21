package by.dzrvnsk.smartcountries

import android.app.Application
import android.content.Context
import by.dzrvnsk.smartcountries.module.networkModule
import by.dzrvnsk.smartcountries.module.viewModelModule
import org.koin.android.ext.android.startKoin

class MyApp : Application() {

    private var context: Context? = null

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin(this, listOf(networkModule, viewModelModule))
    }

    fun getContext(): Context? {
        return context
    }
}