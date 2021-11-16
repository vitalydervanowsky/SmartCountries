package by.dzrvnsk.smartcountries.quiz

import by.dzrvnsk.smartcountries.model.response.Country

data class Question(
    val answer: Country,
    val option1: Country,
    val option2: Country,
    val option3: Country,
    val option4: Country
)
