package by.dzrvnsk.smartcountries.data.mapper

import by.dzrvnsk.smartcountries.data.database.users.UserEntity
import by.dzrvnsk.smartcountries.domain.UserDomain

class UsersMapperImpl: UsersMapper {
    override fun entityToDomain(user: UserEntity): UserDomain =
        user.toDomain()
}

fun UserEntity.toDomain(): UserDomain =
    UserDomain(
        login = this.login,
    )