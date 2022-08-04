package com.example.covidapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.covidapp.common.ApiUtils
import com.example.covidapp.data.StatisticModel
import com.example.covidapp.data.StatisticResponse
import com.example.covidapp.service.CovidAPI
import com.example.covidapp.service.CovidAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidRepository {
    var countryList = MutableLiveData<List<StatisticResponse>>()

    private val covidDIF: CovidAPI = ApiUtils.getCovidDAOInterface()

    fun statistics() {
        covidDIF.statistics().enqueue(object : Callback<StatisticModel>  {
            override fun onResponse(call: Call<StatisticModel>, response: Response<StatisticModel>) {

                response.body()?.let { statistic ->
                    statistic.response?.let { list ->
                        countryList.value = list.sortedBy { it.country }
                    }
                }
            }
            override fun onFailure(call: Call<StatisticModel>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("Countries Failure", it) }
            }
        })
    }

    fun search(country:String){
        covidDIF.searchStatisticed(country).enqueue(object : Callback<StatisticModel> {
            override fun onResponse(call: Call<StatisticModel>, response: Response<StatisticModel>
            ) {
                response.body()?.let { statistic ->
                    statistic.response?.let { list ->
                        countryList.value = list
                    }
                }
            }
            override fun onFailure(call: Call<StatisticModel>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("Countries Failure", it) }
            }
        })
    }
}