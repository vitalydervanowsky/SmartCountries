package by.dzrvnsk.smartcountries.data.usecase

import by.dzrvnsk.smartcountries.data.repository.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RegisterUserUseCaseImpl(
    private val repository: UsersRepository
): RegisterUserUseCase {
    override suspend fun registerUser(login: String, password: String): Boolean =
        withContext(Dispatchers.IO) {
            repository.registerUser(login, password)
        }
}
