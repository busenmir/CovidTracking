package com.example.covidapp.service

import com.example.covidapp.data.StatisticModel
import com.example.covidapp.data.StatisticResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class CovidAPIService {
    companion object {
        private val api = Retrofit.Builder()
        private val client = OkHttpClient.Builder().addInterceptor { chain ->
            val request: Request = chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("X-RapidAPI-Key", "bbefaa5fadmshcf98ce55878bdd8p1541ecjsnbbfef3c53050")
                .addHeader("X-RapidAPI-Host", "covid-193.p.rapidapi.com")
                .build()
            chain.proceed(request)
        }.build()

        fun getClient(baseUrl: String): Retrofit {
            return api
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }

}