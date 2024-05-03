package by.dzrvnsk.smartcountries.data.repository

import androidx.annotation.WorkerThread
import by.dzrvnsk.smartcountries.data.database.scores.ScoreEntity
import by.dzrvnsk.smartcountries.data.database.scores.ScoresDao
import by.dzrvnsk.smartcountries.data.mapper.ScoresMapper
import by.dzrvnsk.smartcountries.domain.ScoreDomain

class ScoresRepositoryImpl(
    private val scoresDao: ScoresDao,
    private val scoresMapper: ScoresMapper,
) : ScoresRepository {

    @WorkerThread
    override suspend fun saveResult(
        login: String,
        scores: Int,
        points: Float,
        duration: Long,
        date: Long
    ): ScoreDomain {
        val entity = ScoreEntity(
            login = login,
            scores = scores,
            points = points,
            duration = duration,
            date = date
        )
        scoresDao.saveResult(
            entity
        )
        return scoresMapper.entityToDomain(entity)
    }

    @WorkerThread
    override suspend fun getScores(): List<ScoreDomain> =
        scoresDao.getScores().map { scoresMapper.entityToDomain(it) }

    @WorkerThread
    override suspend fun deleteAll() {
        scoresDao.deleteAll()
    }
}
