package by.dzrvnsk.smartcountries.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun registerUser(user: User)

    @Query("SELECT * from users where login=(:login) and password=(:password)")
    suspend fun loginUser(login: String, password: String): User?

}