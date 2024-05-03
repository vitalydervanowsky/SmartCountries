package by.dzrvnsk.smartcountries.di

import by.dzrvnsk.smartcountries.data.api.createRetrofit
import org.koin.dsl.module.module

val networkModule = module {
    single { createRetrofit() }
}