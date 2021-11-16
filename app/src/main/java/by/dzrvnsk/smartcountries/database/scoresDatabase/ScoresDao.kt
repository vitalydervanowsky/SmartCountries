package by.dzrvnsk.smartcountries.database.scoresDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ScoresDao {

    @Query("SELECT * FROM scores ORDER BY points DESC")
    suspend fun getScores(): List<QuizResult>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveResult(quizResult: QuizResult)

    @Query("DELETE FROM scores")
    suspend fun deleteAll()
}
