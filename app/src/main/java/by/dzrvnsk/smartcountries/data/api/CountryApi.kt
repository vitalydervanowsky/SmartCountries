package by.dzrvnsk.smartcountries.data.api

import by.dzrvnsk.smartcountries.data.response.Country
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

private const val BASE_URL = "https://restcountries.com/v3.1/"

private fun httpLoggingInterceptor() = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private fun okHttpClient() =
    OkHttpClient().newBuilder()
        .addInterceptor(httpLoggingInterceptor())
        .build()

fun createRetrofit(): CountryApi =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient())
        .build()
        .create()

interface CountryApi {
    @GET("all/")
    fun getAllCountries(): Call<List<Country>>
}
