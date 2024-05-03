package by.dzrvnsk.smartcountries.data.usecase

import by.dzrvnsk.smartcountries.data.repository.ScoresRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ResetScoresUseCaseImpl(
    private val repository: ScoresRepository
): ResetScoresUseCase {
    override suspend fun resetResults() =
        withContext(Dispatchers.IO) {
            repository.deleteAll()
        }
}
