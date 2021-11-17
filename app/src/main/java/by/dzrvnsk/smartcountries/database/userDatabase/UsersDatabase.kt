package by.dzrvnsk.smartcountries.database.userDatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {

    abstract val userDao: UserDao
}
