package by.dzrvnsk.smartcountries.data.database.countries

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class CountryEntity(
    @PrimaryKey val name: String,
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
)
