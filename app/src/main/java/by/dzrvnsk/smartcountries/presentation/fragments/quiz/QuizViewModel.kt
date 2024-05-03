package by.dzrvnsk.smartcountries.presentation.fragments.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.dzrvnsk.smartcountries.data.usecase.GetAllCountriesUseCase
import by.dzrvnsk.smartcountries.data.usecase.SaveResultsUseCase
import by.dzrvnsk.smartcountries.domain.CountryDomain
import by.dzrvnsk.smartcountries.domain.ScoreDomain
import by.dzrvnsk.smartcountries.presentation.fragments.quiz.QuizFragment.Companion.QUIZ_SIZE
import by.dzrvnsk.smartcountries.presentation.model.Question
import kotlinx.coroutines.launch
import java.util.Calendar
import kotlin.random.Random

class QuizViewModel(
    private val getAllCountriesUseCase: GetAllCountriesUseCase,
    private val saveResultsUseCase: SaveResultsUseCase,
) : ViewModel() {

    private val usedCountries = mutableListOf<Int>()

    private val questionsLiveData = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> = questionsLiveData

    private val saveResultsLiveData = MutableLiveData<ScoreDomain?>(null)
    val saveResults: LiveData<ScoreDomain?> = saveResultsLiveData

    init {
        getAllCountries()
    }

    private fun getAllCountries(isForce: Boolean = false) {
        viewModelScope.launch {
            runCatching {
                getAllCountriesUseCase.getAllCountries(isForce)
            }.onSuccess {
                prepareQuestions(it)
            }
        }
    }

    private fun prepareQuestions(countries: List<CountryDomain>) {
        val questions = mutableListOf<Question>()
        for (i in 0 until QUIZ_SIZE) {
            usedCountries.clear()
            val country1 = getRandomCountry(countries)
            val country2 = getRandomCountry(countries)
            val country3 = getRandomCountry(countries)
            val country4 = getRandomCountry(countries)
            val correctAnswerCountry = when (Random.nextInt(4)) {
                0 -> country1
                1 -> country2
                2 -> country3
                else -> country4
            }
            questions.add(
                Question(
                    correctAnswerCountry,
                    listOf(
                        country1,
                        country2,
                        country3,
                        country4
                    )
                )
            )
        }
        questionsLiveData.value = questions
    }

    private fun getRandomCountry(countries: List<CountryDomain>): CountryDomain {
        var number = Random.nextInt(countries.size)
        while (usedCountries.contains(number)) {
            number = Random.nextInt(countries.size)
        }
        usedCountries.add(number)
        return countries[number]
    }

    fun saveResults(login: String, scores: Int, points: Float, duration: Long) {
        viewModelScope.launch {
            runCatching {
                saveResultsUseCase.saveResults(
                    login = login,
                    scores = scores,
                    points = points,
                    duration = duration,
                    date = Calendar.getInstance().timeInMillis
                )
            }.onSuccess {
                saveResultsLiveData.value = it
            }.onFailure {
                saveResultsLiveData.value = null
            }
        }
    }

    fun clearResult() {
        saveResultsLiveData.value = null
    }
}
