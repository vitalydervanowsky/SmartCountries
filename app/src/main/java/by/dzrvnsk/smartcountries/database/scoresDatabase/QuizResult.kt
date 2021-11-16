package by.dzrvnsk.smartcountries.database.scoresDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scores")
data class QuizResult(

    @ColumnInfo(name = "login")
    val login: String,

    @ColumnInfo(name = "scores")
    val scores: Int,

    @PrimaryKey
    @ColumnInfo(name = "points")
    val points: Float

)
