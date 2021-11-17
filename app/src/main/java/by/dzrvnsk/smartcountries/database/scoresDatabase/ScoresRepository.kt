package by.dzrvnsk.smartcountries.database.scoresDatabase

import androidx.annotation.WorkerThread

class ScoresRepository(private val scoresDao: ScoresDao) {

    @WorkerThread
    suspend fun saveResult(quizResult: QuizResult) {
        scoresDao.saveResult(quizResult)
    }

    @WorkerThread
    suspend fun getScores(): List<QuizResult> = scoresDao.getScores()

    @WorkerThread
    suspend fun deleteAll() {
        scoresDao.deleteAll()
    }
}
