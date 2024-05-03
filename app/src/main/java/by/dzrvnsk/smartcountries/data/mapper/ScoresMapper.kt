package by.dzrvnsk.smartcountries.data.mapper

import by.dzrvnsk.smartcountries.data.database.scores.ScoreEntity
import by.dzrvnsk.smartcountries.domain.ScoreDomain

interface ScoresMapper {
    fun entityToDomain(scoreEntity: ScoreEntity): ScoreDomain
    fun domainToEntity(scoreDomain: ScoreDomain): ScoreEntity
}
