package com.example.covidapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatisticResponse(
    var cases: CaseModel?,
    var continent: String?,
    var country: String?,
    var day: String?,
    var deaths: DeathModel?,
    var population: Int?,
    var tests: TestModel?,
    var time: String?
) : Parcelable