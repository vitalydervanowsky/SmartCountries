package by.dzrvnsk.smartcountries.data.repository

import by.dzrvnsk.smartcountries.data.api.CountryApi
import by.dzrvnsk.smartcountries.data.database.countries.CountryDao
import by.dzrvnsk.smartcountries.data.mapper.CountryMapper
import by.dzrvnsk.smartcountries.domain.CountryDomain

class CountriesRepositoryImpl(
    private val countryApi: CountryApi,
    private val countryDao: CountryDao,
    private val countryMapper: CountryMapper
) : CountriesRepository {

    override suspend fun getAllCountries(isForce: Boolean): List<CountryDomain> {
        return if (isForce) {
            getCountriesFromApi()
        } else {
            val localCountries = countryDao.getAllCountries()
            if (localCountries.isNotEmpty()) {
                countryMapper.entityToDomain(localCountries)
            } else {
                getCountriesFromApi()
            }
        }
    }

    private suspend fun getCountriesFromApi(): List<CountryDomain> {
        countryDao.nukeTable()
        val countries = countryApi.getAllCountries().execute().body()
            ?: emptyList()
        countryDao.saveCountries(countryMapper.dtoToEntity(countries))
        return countryMapper.entityToDomain(countryDao.getAllCountries())
    }
}
