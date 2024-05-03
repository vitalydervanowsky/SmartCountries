package by.dzrvnsk.smartcountries.di

import by.dzrvnsk.smartcountries.data.mapper.CountryMapper
import by.dzrvnsk.smartcountries.data.mapper.CountryMapperImpl
import by.dzrvnsk.smartcountries.data.mapper.ScoresMapper
import by.dzrvnsk.smartcountries.data.mapper.ScoresMapperImpl
import by.dzrvnsk.smartcountries.data.mapper.UsersMapper
import by.dzrvnsk.smartcountries.data.mapper.UsersMapperImpl
import org.koin.dsl.module.module

val mapperModule = module {
    single<CountryMapper> { CountryMapperImpl() }
    single<UsersMapper> { UsersMapperImpl() }
    single<ScoresMapper> { ScoresMapperImpl() }
}