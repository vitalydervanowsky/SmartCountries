package by.dzrvnsk.smartcountries.quiz

import by.dzrvnsk.smartcountries.model.response.Country

data class Question(
    val answer: Country,
    val option1: Country,
    val option2: Country,
    val option3: Country,
    val option4: Country
) {
    override fun toString(): String =
        "${option1.name.common} * ${option2.name.common} * ${option3.name.common} * ${option4.name.common}"
}