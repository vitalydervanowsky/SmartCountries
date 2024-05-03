package by.dzrvnsk.smartcountries.data.repository

import by.dzrvnsk.smartcountries.domain.ScoreDomain

interface ScoresRepository {
    suspend fun saveResult(
        login: String,
        scores: Int,
        points: Float,
        duration: Long,
        date: Long
    ): ScoreDomain

    suspend fun getScores(): List<ScoreDomain>
    suspend fun deleteAll()
}
