package by.dzrvnsk.smartcountries.data.mapper

import by.dzrvnsk.smartcountries.data.database.countries.CountryEntity
import by.dzrvnsk.smartcountries.data.response.Country
import by.dzrvnsk.smartcountries.domain.CountryDomain

interface CountryMapper {
    fun entityToDomain(list: List<CountryEntity>): List<CountryDomain>
    fun dtoToEntity(list: List<Country>): List<CountryEntity>
}
