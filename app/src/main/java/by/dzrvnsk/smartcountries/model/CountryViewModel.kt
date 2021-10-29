package by.dzrvnsk.smartcountries.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.dzrvnsk.smartcountries.response.ApiCountry
import by.dzrvnsk.smartcountries.response.Countries
import by.dzrvnsk.smartcountries.response.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback

class CountryViewModel(private val apiCountry: ApiCountry) : ViewModel() {

    private val _countriesLiveData = MutableLiveData<Countries>()
    private val _currentCountryLiveData = MutableLiveData<Country>()

    fun fetchCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            apiCountry.getCountries().enqueue(object : Callback<Countries> {
                override fun onResponse(
                    call: Call<Countries>,
                    response: retrofit2.Response<Countries>
                ) {
                    _countriesLiveData.value = response.body()
                    _currentCountryLiveData.value = response.body()?.first()
                }

                override fun onFailure(call: Call<Countries>, t: Throwable) {
                }
            })
        }
    }

    fun getCountriesLiveData(): LiveData<Countries> = _countriesLiveData

    fun getCurrentCountryLiveData(): LiveData<Country> = _currentCountryLiveData

    fun setCurrentCountryLiveData(country: Country) {
        _currentCountryLiveData.value = country
    }
}