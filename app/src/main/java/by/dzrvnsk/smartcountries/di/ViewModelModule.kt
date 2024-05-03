package by.dzrvnsk.smartcountries.di

import by.dzrvnsk.smartcountries.presentation.fragments.countrylist.CountryListViewModel
import by.dzrvnsk.smartcountries.presentation.fragments.login.LoginViewModel
import by.dzrvnsk.smartcountries.presentation.fragments.quiz.QuizViewModel
import by.dzrvnsk.smartcountries.presentation.fragments.registration.RegistrationViewModel
import by.dzrvnsk.smartcountries.presentation.fragments.scores.ScoresViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel {
        CountryListViewModel(
            get(),
        )
    }
    viewModel {
        RegistrationViewModel(
            get(),
        )
    }
    viewModel {
        LoginViewModel(
            get(),
        )
    }
    viewModel {
        QuizViewModel(
            get(),
            get(),
        )
    }
    viewModel {
        ScoresViewModel(
            get(),
            get(),
        )
    }
}
