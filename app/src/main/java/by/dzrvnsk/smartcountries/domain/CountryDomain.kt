package by.dzrvnsk.smartcountries.domain

import java.io.Serializable

data class CountryDomain(
    val name: String,
    val nameOfficial: String,
    val countryLat: Double,
    val countryLng: Double,
    val area: Double,
    val population: Int,
    val openStreetMaps: String,
    val capital: String,
    val capitalLat: String,
    val capitalLng: String,
    val flag: String,
    val region: String,
    val subregion: String,
) : Serializable
