package by.dzrvnsk.currency.database

import androidx.annotation.WorkerThread

class UserRepository(private val userDao: UserDao) {

    @WorkerThread
    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }

}