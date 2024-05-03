package by.dzrvnsk.smartcountries.data.usecase

import by.dzrvnsk.smartcountries.data.repository.ScoresRepository
import by.dzrvnsk.smartcountries.domain.ScoreDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SaveResultsUseCaseImpl(
    private val repository: ScoresRepository
) : SaveResultsUseCase {
    override suspend fun saveResults(
        login: String,
        scores: Int,
        points: Float,
        duration: Long,
        date: Long
    ): ScoreDomain =
        withContext(Dispatchers.IO) {
            repository.saveResult(
                login = login,
                scores = scores,
                points = points,
                duration = duration,
                date = date
            )
        }
}
