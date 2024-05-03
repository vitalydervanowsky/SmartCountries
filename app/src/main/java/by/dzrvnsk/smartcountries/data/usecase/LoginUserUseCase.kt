package by.dzrvnsk.smartcountries.data.usecase

import by.dzrvnsk.smartcountries.domain.UserDomain

interface LoginUserUseCase {
    suspend fun loginUser(login: String, password: String): UserDomain?
}
