package by.dzrvnsk.smartcountries.database.userDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(

    @PrimaryKey @ColumnInfo(name = "login")
    val login: String,

    @ColumnInfo(name = "password")
    val password: String

)
