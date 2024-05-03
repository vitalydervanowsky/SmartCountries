package by.dzrvnsk.smartcountries.data.database.countries

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {

    @Query("SELECT * FROM country ORDER BY name ASC")
    suspend fun getAllCountries(): List<CountryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCountries(list: List<CountryEntity>)

    @Query("DELETE FROM country")
    fun nukeTable()

//    @Query("SELECT * from users where login=(:login) and password=(:password)")
//    suspend fun loginUser(login: String, password: String): User?
}
