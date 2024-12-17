package com.example.wiserrapps.ui.theme.data.remote

import com.example.wiserrapps.ui.theme.data.remote.retrofit.Api
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    // HttpLoggingInterceptor untuk membantu debugging
    private val loggingInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Menampilkan isi body dari request/response
        }
    }

    // OkHttpClient untuk konfigurasi tambahan seperti timeout
    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS) // Timeout koneksi
            .readTimeout(30, TimeUnit.SECONDS)    // Timeout pembacaan
            .writeTimeout(30, TimeUnit.SECONDS)   // Timeout penulisan
            .build()
    }

    // Retrofit instance untuk mengakses API
    val api: Api by lazy {
        Retrofit.Builder()
            .baseUrl(Api.BASE_URL) // Pastikan Api.BASE_URL sudah didefinisikan di interface Api
            .addConverterFactory(GsonConverterFactory.create()) // Konverter untuk JSON
            .client(client)
            .build()
            .create(Api::class.java)
    }
}
