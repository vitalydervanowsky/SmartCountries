package by.dzrvnsk.smartcountries.data.usecase

import by.dzrvnsk.smartcountries.domain.CountryDomain

interface GetAllCountriesUseCase {
    suspend fun getAllCountries(isForce: Boolean): List<CountryDomain>
}
