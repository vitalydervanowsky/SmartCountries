package by.dzrvnsk.smartcountries.data.database.scores

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ScoresDao {

    @Query("SELECT * FROM scores ORDER BY points DESC")
    suspend fun getScores(): List<ScoreEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveResult(scoreEntity: ScoreEntity)

    @Query("DELETE FROM scores")
    suspend fun deleteAll()
}
