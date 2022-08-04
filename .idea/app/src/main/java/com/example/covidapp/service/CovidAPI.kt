package com.example.covidapp.service

import com.example.covidapp.data.StatisticModel
import com.example.covidapp.data.StatisticResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query

interface CovidAPI {
    @GET("statistics")
    fun statistics(): Call<StatisticModel>

    @GET("history")
    fun history(@Query ("country") country:String): Call<StatisticModel>

    @GET("statistics")
    fun searchStatisticed(@Query("country")country: String ): Call<StatisticModel>
}