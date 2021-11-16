package by.dzrvnsk.smartcountries.database.scoresDatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [QuizResult::class], version = 1, exportSchema = false)
abstract class ScoresDatabase : RoomDatabase() {

    abstract val scoresDao: ScoresDao
}
