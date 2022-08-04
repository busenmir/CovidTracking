package com.example.covidapp.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covidapp.data.StatisticResponse
import com.example.covidapp.repository.CovidRepository

class HomeViewModel : ViewModel() {
    private var covidRepo = CovidRepository()

    private var _countryList = MutableLiveData<List<StatisticResponse>>()
    val countryList: LiveData<List<StatisticResponse>>
        get() = _countryList

    init {
        getStatistics()
    }

    fun getStatistics() {
        covidRepo.statistics()
        _countryList = covidRepo.countryList
    }

    fun searchStatistics(country:String){
        covidRepo.search(country)
        _countryList=covidRepo.countryList
    }
}