package by.dzrvnsk.smartcountries.data.database.users

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(

    @PrimaryKey @ColumnInfo(name = "login")
    val login: String,

    @ColumnInfo(name = "password")
    val password: String

)
