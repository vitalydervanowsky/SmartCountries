package by.dzrvnsk.smartcountries.data.repository

import androidx.annotation.WorkerThread
import by.dzrvnsk.smartcountries.data.database.users.UserDao
import by.dzrvnsk.smartcountries.data.database.users.UserEntity
import by.dzrvnsk.smartcountries.data.mapper.UsersMapper
import by.dzrvnsk.smartcountries.data.mapper.toDomain
import by.dzrvnsk.smartcountries.domain.UserDomain

class UsersRepositoryImpl(
    private val userDao: UserDao,
    private val usersMapper: UsersMapper
) : UsersRepository {

    @WorkerThread
    override suspend fun registerUser(login: String, password: String): Boolean {
        userDao.registerUser(
            UserEntity(
                login = login,
                password = password
            )
        )
        return true
    }

    @WorkerThread
    override suspend fun loginUser(login: String, password: String): UserDomain? =
        userDao.loginUser(login, password)?.let { usersMapper.entityToDomain(it) }
}
