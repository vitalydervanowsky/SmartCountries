package by.dzrvnsk.smartcountries.module

import android.app.Application
import androidx.room.Room
import by.dzrvnsk.smartcountries.database.UserDao
import by.dzrvnsk.smartcountries.database.UserDatabase
import by.dzrvnsk.smartcountries.database.UserRepository
import by.dzrvnsk.smartcountries.model.CountryViewModel
import by.dzrvnsk.smartcountries.response.createRetrofit
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val networkModule = module {
    single { createRetrofit() }
}

val viewModelModule = module {
    viewModel { CountryViewModel(get()) }
}

val databaseModule = module {

    fun provideUserDatabase(application: Application): UserDatabase {
        return Room.databaseBuilder(application, UserDatabase::class.java, "users_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideUserDao(database: UserDatabase): UserDao {
        return database.userDao
    }

    single { provideUserDatabase(get()) }
    single { provideUserDao(get()) }
    single { UserRepository(get()) }
}