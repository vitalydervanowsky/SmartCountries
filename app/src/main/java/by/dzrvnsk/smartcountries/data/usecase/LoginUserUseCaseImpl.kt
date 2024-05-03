package by.dzrvnsk.smartcountries.data.usecase

import by.dzrvnsk.smartcountries.data.repository.UsersRepository
import by.dzrvnsk.smartcountries.domain.UserDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginUserUseCaseImpl(
    private val repository: UsersRepository
) : LoginUserUseCase {
    override suspend fun loginUser(login: String, password: String): UserDomain? =
        withContext(Dispatchers.IO) {
            repository.loginUser(
                login = login,
                password = password
            )
        }
}
