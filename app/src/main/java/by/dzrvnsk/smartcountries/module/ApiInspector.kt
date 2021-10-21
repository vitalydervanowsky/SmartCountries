package by.dzrvnsk.smartcountries.module

import by.dzrvnsk.smartcountries.model.CountryViewModel
import by.dzrvnsk.smartcountries.response.createRetrofit
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val networkModule = module {
    single { createRetrofit() }
}

val viewModelModule = module {
    viewModel { CountryViewModel(get()) }
}