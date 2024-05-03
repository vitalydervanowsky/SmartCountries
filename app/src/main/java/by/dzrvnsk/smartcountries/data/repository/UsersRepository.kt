package by.dzrvnsk.smartcountries.data.repository

import by.dzrvnsk.smartcountries.domain.UserDomain

interface UsersRepository {
    suspend fun registerUser(login: String, password: String): Boolean
    suspend fun loginUser(login: String, password: String): UserDomain?
}