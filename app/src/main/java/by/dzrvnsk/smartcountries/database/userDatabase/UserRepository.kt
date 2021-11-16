package by.dzrvnsk.smartcountries.database.userDatabase

import androidx.annotation.WorkerThread

class UserRepository(private val userDao: UserDao) {

    @WorkerThread
    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }

    @WorkerThread
    suspend fun loginUser(login: String, password: String): User? = userDao.loginUser(login, password)
}
