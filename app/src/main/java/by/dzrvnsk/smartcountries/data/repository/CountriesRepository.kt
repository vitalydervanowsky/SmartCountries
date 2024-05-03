package by.dzrvnsk.smartcountries.data.repository

import by.dzrvnsk.smartcountries.domain.CountryDomain

interface CountriesRepository {
    suspend fun getAllCountries(isForce: Boolean): List<CountryDomain>
}
