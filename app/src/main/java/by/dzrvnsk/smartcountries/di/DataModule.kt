package by.dzrvnsk.smartcountries.di

import android.app.Application
import androidx.room.Room
import by.dzrvnsk.smartcountries.data.database.countries.CountryDao
import by.dzrvnsk.smartcountries.data.database.countries.CountryDatabase
import by.dzrvnsk.smartcountries.data.database.scores.ScoresDao
import by.dzrvnsk.smartcountries.data.database.scores.ScoresDatabase
import by.dzrvnsk.smartcountries.data.repository.ScoresRepositoryImpl
import by.dzrvnsk.smartcountries.data.database.users.UserDao
import by.dzrvnsk.smartcountries.data.repository.UsersRepositoryImpl
import by.dzrvnsk.smartcountries.data.database.users.UsersDatabase
import by.dzrvnsk.smartcountries.data.repository.CountriesRepository
import by.dzrvnsk.smartcountries.data.repository.CountriesRepositoryImpl
import by.dzrvnsk.smartcountries.data.repository.ScoresRepository
import by.dzrvnsk.smartcountries.data.repository.UsersRepository
import org.koin.dsl.module.module

val countriesDbModule = module {
    fun provideCountryDatabase(application: Application): CountryDatabase {
        return Room.databaseBuilder(application, CountryDatabase::class.java, "country_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideCountryDao(database: CountryDatabase): CountryDao {
        return database.countryDao
    }

    single { provideCountryDatabase(get()) }
    single { provideCountryDao(get()) }
    single<CountriesRepository> {
        CountriesRepositoryImpl(
            get(),
            get(),
            get(),
        )
    }
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
    single<UsersRepository> {
        UsersRepositoryImpl(
            get(),
            get(),
        )
    }
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
    single<ScoresRepository> {
        ScoresRepositoryImpl(
            get(),
            get(),
        )
    }
}
