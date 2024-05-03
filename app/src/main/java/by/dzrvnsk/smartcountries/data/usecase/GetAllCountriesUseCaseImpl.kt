package by.dzrvnsk.smartcountries.data.usecase

import by.dzrvnsk.smartcountries.data.repository.CountriesRepository
import by.dzrvnsk.smartcountries.domain.CountryDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAllCountriesUseCaseImpl(
    private val repository: CountriesRepository
) : GetAllCountriesUseCase {

    override suspend fun getAllCountries(isForce: Boolean): List<CountryDomain> =
        withContext(Dispatchers.IO) {
            repository.getAllCountries(isForce)
        }
}
