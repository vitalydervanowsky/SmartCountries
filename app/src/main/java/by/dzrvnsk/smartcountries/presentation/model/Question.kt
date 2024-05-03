package by.dzrvnsk.smartcountries.presentation.model

import by.dzrvnsk.smartcountries.domain.CountryDomain

data class Question(
    val answer: CountryDomain,
    val options: List<CountryDomain>,
)
