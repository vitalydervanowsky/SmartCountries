package by.dzrvnsk.smartcountries.data.usecase

import by.dzrvnsk.smartcountries.domain.ScoreDomain

interface SaveResultsUseCase {
    suspend fun saveResults(
        login: String,
        scores: Int,
        points: Float,
        duration: Long,
        date: Long
    ): ScoreDomain
}
