package by.dzrvnsk.smartcountries.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.dzrvnsk.smartcountries.quiz.Question
import by.dzrvnsk.smartcountries.response.ApiCountry
import by.dzrvnsk.smartcountries.response.Countries
import by.dzrvnsk.smartcountries.response.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import kotlin.random.Random

class CountryViewModel(private val apiCountry: ApiCountry) : ViewModel() {

    private val _countriesLiveData = MutableLiveData<Countries>()
    private val _currentCountryLiveData = MutableLiveData<Country>()
    private val _questionsLiveData = MutableLiveData<List<Question>>()

    private val listOfUsedCountries = mutableListOf<Int>()

    fun getCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            apiCountry.getCountries().enqueue(object : Callback<Countries> {
                override fun onResponse(
                    call: Call<Countries>,
                    response: retrofit2.Response<Countries>
                ) {
                    _countriesLiveData.value = response.body()
                    _currentCountryLiveData.value = response.body()?.first()
                    _questionsLiveData.value = response.body()?.let { getQuestions(it) }
                }

                override fun onFailure(call: Call<Countries>, t: Throwable) {
                }
            })
        }
    }

    private fun getQuestions(list: Countries): List<Question> {
        val listOfQuestions = mutableListOf<Question>()
        for (i in 0..9) {
            listOfUsedCountries.clear()
            val country1 = getRandomCountry(list)
            val country2 = getRandomCountry(list)
            val country3 = getRandomCountry(list)
            val country4 = getRandomCountry(list)
            val correctAnswerCountry = when (Random.nextInt(4)) {
                0 -> country1
                1 -> country2
                2 -> country3
                else -> country4
            }

            listOfQuestions.add(
                Question(
                    correctAnswerCountry,
                    country1,
                    country2,
                    country3,
                    country4
                )
            )
        }
        return listOfQuestions
    }

    private fun getRandomCountry(list: Countries): Country {
        var number: Int
        do {
            number = Random.nextInt(list.size)
        } while (listOfUsedCountries.contains(number))
        listOfUsedCountries.add(number)
        return list[number]
    }

    fun getCountriesLiveData(): LiveData<Countries> = _countriesLiveData

    fun getCurrentCountryLiveData(): LiveData<Country> = _currentCountryLiveData

    fun getQuestionsLiveData(): LiveData<List<Question>> = _questionsLiveData

    fun setCurrentCountryLiveData(country: Country) {
        _currentCountryLiveData.value = country
    }
}