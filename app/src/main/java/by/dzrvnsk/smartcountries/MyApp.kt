package by.dzrvnsk.smartcountries

import android.app.Application
import android.content.Context
import androidx.room.Room
import by.dzrvnsk.smartcountries.database.scoresDatabase.ScoresDao
import by.dzrvnsk.smartcountries.database.scoresDatabase.ScoresDatabase
import by.dzrvnsk.smartcountries.database.scoresDatabase.ScoresRepository
import by.dzrvnsk.smartcountries.database.userDatabase.UserDao
import by.dzrvnsk.smartcountries.database.userDatabase.UserRepository
import by.dzrvnsk.smartcountries.database.userDatabase.UsersDatabase
import by.dzrvnsk.smartcountries.model.request.createRetrofit
import by.dzrvnsk.smartcountries.viewModel.CountryViewModel
import org.koin.android.ext.android.startKoin
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class MyApp : Application() {

    private var context: Context? = null

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin(
            this,
            listOf(
                networkModule,
                viewModelModule,
                scoresDbModule,
                usersDbModule
            )
        )
    }

    fun getContext(): Context? {
        return context
    }
}

val networkModule = module {
    single { createRetrofit() }
}

val viewModelModule = module {
    viewModel { CountryViewModel(get()) }
}

val usersDbModule = module {

    fun provideUserDatabase(application: Application): UsersDatabase {
        return Room.databaseBuilder(application, UsersDatabase::class.java, "users_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideUserDao(database: UsersDatabase): UserDao {
        return database.userDao
    }

    single { provideUserDatabase(get()) }
    single { provideUserDao(get()) }
    single { UserRepository(get()) }
}

val scoresDbModule = module {
    fun provideScoresDatabase(application: Application): ScoresDatabase {
        return Room.databaseBuilder(application, ScoresDatabase::class.java, "scores_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideScoresDao(scoresDatabase: ScoresDatabase): ScoresDao {
        return scoresDatabase.scoresDao
    }
    single { provideScoresDatabase(get()) }
    single { provideScoresDao(get()) }
    single { ScoresRepository(get()) }
}
