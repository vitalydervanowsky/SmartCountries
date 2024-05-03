package by.dzrvnsk.smartcountries.presentation.fragments.scores

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.dzrvnsk.smartcountries.data.usecase.GetScoresUseCase
import by.dzrvnsk.smartcountries.data.usecase.ResetScoresUseCase
import by.dzrvnsk.smartcountries.domain.ScoreDomain
import kotlinx.coroutines.launch

class ScoresViewModel(
    private val getScoresUseCase: GetScoresUseCase,
    private val resetScoresUseCase: ResetScoresUseCase,
) : ViewModel() {

    private val scoresLiveData = MutableLiveData<List<ScoreDomain>>()
    val scores: LiveData<List<ScoreDomain>> = scoresLiveData

    init {
        getScores()
    }

    private fun getScores() {
        viewModelScope.launch {
            runCatching {
                getScoresUseCase.getScores()
            }.onSuccess {
                scoresLiveData.value = it
            }
        }
    }

    fun resetResults() {
        viewModelScope.launch {
            runCatching {
                resetScoresUseCase.resetResults()
            }.onSuccess {
                scoresLiveData.value = emptyList()
            }
        }
    }
}
