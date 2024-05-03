package by.dzrvnsk.smartcountries.data.mapper

import by.dzrvnsk.smartcountries.data.database.users.UserEntity
import by.dzrvnsk.smartcountries.domain.UserDomain

interface UsersMapper {
    fun entityToDomain(user: UserEntity): UserDomain
}