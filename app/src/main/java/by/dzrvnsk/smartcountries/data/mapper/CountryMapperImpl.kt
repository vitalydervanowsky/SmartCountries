package by.dzrvnsk.smartcountries.data.mapper

import by.dzrvnsk.smartcountries.data.database.countries.CountryEntity
import by.dzrvnsk.smartcountries.data.response.Country
import by.dzrvnsk.smartcountries.domain.CountryDomain

class CountryMapperImpl : CountryMapper {

    override fun entityToDomain(list: List<CountryEntity>): List<CountryDomain> =
        list.map { it.toDomain() }

    override fun dtoToEntity(list: List<Country>): List<CountryEntity> =
        list.map { it.toEntity() }
}

fun CountryEntity.toDomain(): CountryDomain =
    CountryDomain(
        name = this.name,
        nameOfficial = this.nameOfficial,
        countryLat = this.countryLat,
        countryLng = this.countryLng,
        area = this.area,
        population = this.population,
        openStreetMaps = this.openStreetMaps,
        capital = this.capital,
        capitalLat = this.capitalLat,
        capitalLng = this.capitalLng,
        flag = this.flag,
        region = this.region,
        subregion = this.subregion,
    )

fun Country.toEntity(): CountryEntity =
    CountryEntity(
        name = this.name?.common ?: "",
        nameOfficial = this.name?.official ?: "",
        countryLat = this.latlng?.get(0) ?: 0.0,
        countryLng = this.latlng?.get(1) ?: 0.0,
        area = this.area ?: 0.0,
        population = this.population ?: 0,
        openStreetMaps = this.maps?.openStreetMaps ?: "",
        capital = this.capital?.firstOrNull() ?: "",
        capitalLat = this.capitalInfo?.latlng?.get(0).toString(),
        capitalLng = this.capitalInfo?.latlng?.get(1).toString(),
        flag = this.flags?.png ?: "",
        region = this.region ?: "",
        subregion = this.subregion ?: "",
    )
