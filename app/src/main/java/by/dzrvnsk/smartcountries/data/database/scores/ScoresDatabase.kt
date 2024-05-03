package by.dzrvnsk.smartcountries.data.database.scores

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ScoreEntity::class], version = 1, exportSchema = false)
abstract class ScoresDatabase : RoomDatabase() {

    abstract val scoresDao: ScoresDao
}
