package by.dzrvnsk.smartcountries

import android.app.Application
import android.content.Context
import by.dzrvnsk.smartcountries.di.countriesDbModule
import by.dzrvnsk.smartcountries.di.mapperModule
import by.dzrvnsk.smartcountries.di.networkModule
import by.dzrvnsk.smartcountries.di.scoresDbModule
import by.dzrvnsk.smartcountries.di.useCaseModule
import by.dzrvnsk.smartcountries.di.usersDbModule
import by.dzrvnsk.smartcountries.di.viewModelModule
import org.koin.android.ext.android.startKoin

class MyApp : Application() {

    private var context: Context? = null

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin(
            this,
            listOf(
                networkModule,
                mapperModule,
                countriesDbModule,
                usersDbModule,
                scoresDbModule,
                useCaseModule,
                viewModelModule
            )
        )
    }

    fun getContext(): Context? {
        return context
    }
}
