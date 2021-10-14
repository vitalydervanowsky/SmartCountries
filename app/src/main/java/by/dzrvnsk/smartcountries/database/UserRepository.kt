package by.dzrvnsk.smartcountries.database

import androidx.annotation.WorkerThread

class UserRepository(private val userDao: UserDao) {

    @WorkerThread
    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }

    @WorkerThread
    suspend fun login(email: String, password: String): User? = userDao.login(email, password)

}