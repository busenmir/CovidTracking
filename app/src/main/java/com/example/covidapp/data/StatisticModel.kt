package com.example.covidapp.data

data class StatisticModel(
    var get: String?,
    //var parameters: List<String>?,
    var errors: List<String>?,
    var results: Int?,
    var response: List<StatisticResponse>?
)