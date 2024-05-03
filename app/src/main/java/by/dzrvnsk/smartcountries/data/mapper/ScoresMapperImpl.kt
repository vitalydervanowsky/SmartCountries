package by.dzrvnsk.smartcountries.data.mapper

import by.dzrvnsk.smartcountries.data.database.scores.ScoreEntity
import by.dzrvnsk.smartcountries.domain.ScoreDomain

class ScoresMapperImpl : ScoresMapper {

    override fun entityToDomain(scoreEntity: ScoreEntity): ScoreDomain =
        ScoreDomain(
            login = scoreEntity.login,
            scores = scoreEntity.scores,
            points = scoreEntity.points,
            duration = scoreEntity.duration,
            date = scoreEntity.date
        )

    override fun domainToEntity(scoreDomain: ScoreDomain): ScoreEntity =
        ScoreEntity(
            login = scoreDomain.login,
            scores = scoreDomain.scores,
            points = scoreDomain.points,
            duration = scoreDomain.duration,
            date = scoreDomain.date
        )
}
