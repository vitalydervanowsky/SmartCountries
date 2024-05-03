package by.dzrvnsk.smartcountries.domain

import java.io.Serializable

data class ScoreDomain(
    val login: String,
    val scores: Int,
    val points: Float,
    val duration: Long,
    val date: Long,
) : Serializable
