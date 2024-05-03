package by.dzrvnsk.smartcountries.di

import by.dzrvnsk.smartcountries.data.usecase.GetAllCountriesUseCase
import by.dzrvnsk.smartcountries.data.usecase.GetAllCountriesUseCaseImpl
import by.dzrvnsk.smartcountries.data.usecase.GetScoresUseCase
import by.dzrvnsk.smartcountries.data.usecase.GetScoresUseCaseImpl
import by.dzrvnsk.smartcountries.data.usecase.LoginUserUseCaseImpl
import by.dzrvnsk.smartcountries.data.usecase.LoginUserUseCase
import by.dzrvnsk.smartcountries.data.usecase.RegisterUserUseCase
import by.dzrvnsk.smartcountries.data.usecase.RegisterUserUseCaseImpl
import by.dzrvnsk.smartcountries.data.usecase.ResetScoresUseCase
import by.dzrvnsk.smartcountries.data.usecase.ResetScoresUseCaseImpl
import by.dzrvnsk.smartcountries.data.usecase.SaveResultsUseCase
import by.dzrvnsk.smartcountries.data.usecase.SaveResultsUseCaseImpl
import org.koin.dsl.module.module

val useCaseModule = module {
    single<RegisterUserUseCase> { RegisterUserUseCaseImpl(get()) }
    single<LoginUserUseCase> { LoginUserUseCaseImpl(get()) }
    single<GetAllCountriesUseCase> { GetAllCountriesUseCaseImpl(get()) }
    single<SaveResultsUseCase> { SaveResultsUseCaseImpl(get()) }
    single<GetScoresUseCase> { GetScoresUseCaseImpl(get()) }
    single<ResetScoresUseCase> { ResetScoresUseCaseImpl(get()) }
}
