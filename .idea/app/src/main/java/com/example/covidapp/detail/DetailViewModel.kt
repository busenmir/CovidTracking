package com.example.covidapp.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covidapp.data.StatisticResponse
import com.example.covidapp.repository.CovidRepository

class DetailViewModel : ViewModel() {
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
}