package by.dzrvnsk.smartcountries.data.database.scores

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scores")
data class ScoreEntity(

    @ColumnInfo(name = "login")
    val login: String,

    @ColumnInfo(name = "scores")
    val scores: Int,

    @PrimaryKey
    @ColumnInfo(name = "points")
    val points: Float,

    @ColumnInfo(name = "duration")
    val duration: Long,

    @ColumnInfo(name = "date")
    val date: Long,
)
