package com.example.currencyconverterapp

import com.example.currencyconverterapp.model.Currency
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL = "https://api.currencylayer.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

val client : OkHttpClient = OkHttpClient.Builder().apply {
    addInterceptor(interceptor)
    addInterceptor(AuthInterceptor())
} .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface CurrencyApiService {
    @GET("live")
    suspend fun getRates(): Currency
}
object CurrencyApi {
    val retrofitService : CurrencyApiService =
        retrofit.create(CurrencyApiService::class.java)
}
