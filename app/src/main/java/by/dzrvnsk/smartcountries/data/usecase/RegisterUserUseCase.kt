package by.dzrvnsk.smartcountries.data.usecase

interface RegisterUserUseCase {
    suspend fun registerUser(login: String, password: String): Boolean
}
