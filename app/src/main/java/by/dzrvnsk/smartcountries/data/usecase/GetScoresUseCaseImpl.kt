package by.dzrvnsk.smartcountries.data.usecase

import by.dzrvnsk.smartcountries.data.repository.ScoresRepository
import by.dzrvnsk.smartcountries.domain.ScoreDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetScoresUseCaseImpl(
    private val repository: ScoresRepository,
): GetScoresUseCase {
    override suspend fun getScores(): List<ScoreDomain> =
        withContext(Dispatchers.IO) {
            repository.getScores()
        }
}
