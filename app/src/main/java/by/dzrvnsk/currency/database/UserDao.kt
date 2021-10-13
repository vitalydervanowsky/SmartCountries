package by.dzrvnsk.currency.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun registerUser(user: User)

    @Query("SELECT * from users where email=(:email) and password=(:password)")
    suspend fun login(email: String, password: String): User?

}