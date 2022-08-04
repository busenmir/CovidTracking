package com.example.covidapp.common

import com.example.covidapp.service.CovidAPI
import com.example.covidapp.service.CovidAPIService

class ApiUtils {
    companion object {

        fun getCovidDAOInterface(): CovidAPI {
            return CovidAPIService.getClient("https://covid-193.p.rapidapi.com/").create(CovidAPI::class.java)
        }
    }
}