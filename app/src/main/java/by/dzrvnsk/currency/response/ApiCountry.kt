package by.dzrvnsk.currency.response

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiCountry {

    @GET("all/")
    fun getCountries(): Call<Countries>

    companion object {
        private const val BASE_URL = "https://restcountries.com/v3.1/"
        private val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        private val okHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()

        fun create(): ApiCountry {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()
            return retrofit.create()
        }
    }
}