package by.dzrvnsk.smartcountries.data.usecase

import by.dzrvnsk.smartcountries.domain.ScoreDomain

interface GetScoresUseCase {
    suspend fun getScores(): List<ScoreDomain>
}
