package by.dzrvnsk.smartcountries.presentation.fragments.countrylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.dzrvnsk.smartcountries.data.usecase.GetAllCountriesUseCase
import by.dzrvnsk.smartcountries.domain.CountryDomain
import kotlinx.coroutines.launch
import java.util.Locale

class CountryListViewModel(
    private val getAllCountriesUseCase: GetAllCountriesUseCase,
) : ViewModel() {

    private var fullList: List<CountryDomain>? = null
    private var lastQuery = ""
    private val locale = Locale.getDefault()

    private val countriesLiveData = MutableLiveData<List<CountryDomain>?>()
    val countries: LiveData<List<CountryDomain>?> = countriesLiveData

    fun getAllCountries(isForce: Boolean = false) {
        viewModelScope.launch {
            runCatching {
                getAllCountriesUseCase.getAllCountries(isForce)
            }.onSuccess {
                fullList = it
                filterByName(lastQuery)
            }
        }
    }

    fun filterByName(query: String) {
        lastQuery = query.lowercase(locale)
        countriesLiveData.value = if (lastQuery.isNotEmpty()) {
            fullList?.filter {
                it.name.lowercase(locale).contains(lastQuery) ||
                        it.region.lowercase(locale).contains(lastQuery) ||
                        it.subregion.lowercase(locale).contains(lastQuery)
            }
        } else {
            fullList
        }
    }
}
