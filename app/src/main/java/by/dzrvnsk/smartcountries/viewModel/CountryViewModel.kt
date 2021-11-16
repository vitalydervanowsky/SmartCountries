package by.dzrvnsk.smartcountries.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.dzrvnsk.smartcountries.model.request.ApiCountry
import by.dzrvnsk.smartcountries.model.response.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryViewModel(private val apiCountry: ApiCountry) : ViewModel() {

    private val _countriesLiveData = MutableLiveData<ArrayList<Country>>()
    private val _currentCountryLiveData = MutableLiveData<Country>()

    fun fetchCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            apiCountry.getCountries().enqueue(object : Callback<ArrayList<Country>> {
                override fun onResponse(
                    call: Call<ArrayList<Country>>,
                    response: Response<ArrayList<Country>>
                ) {
                    _countriesLiveData.value = response.body()
                }

                override fun onFailure(call: Call<ArrayList<Country>>, t: Throwable) {
                }
            })
        }
    }

    fun getCountriesLiveData(): LiveData<ArrayList<Country>> = _countriesLiveData

    fun getCurrentCountryLiveData(): LiveData<Country> = _currentCountryLiveData

    fun setCurrentCountryLiveData(country: Country) {
        _currentCountryLiveData.value = country
    }
}
