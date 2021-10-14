package by.dzrvnsk.currency.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.dzrvnsk.currency.response.ApiCountry
import by.dzrvnsk.currency.response.Countries
import by.dzrvnsk.currency.response.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback

class CountryViewModel : ViewModel() {

    val countriesLiveData = MutableLiveData<Countries>()
    private val currentCountryLiveData = MutableLiveData<Country>()

    private val apiCountries = ApiCountry.create().getCountries()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            apiCountries.enqueue(object : Callback<Countries> {
                override fun onResponse(
                    call: Call<Countries>,
                    response: retrofit2.Response<Countries>
                ) {
                    countriesLiveData.value = response.body()
                }

                override fun onFailure(call: Call<Countries>, t: Throwable) {
                }
            })
        }
    }

    fun setCurrentCountry(country: Country) {
        currentCountryLiveData.value = country
    }
}