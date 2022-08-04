package com.example.covidapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CaseModel(
    @SerializedName("1M_pop") var one_m_pop: String?,
    var active: Int?,
    var critical: Int?,
    var new: Int? = 0,
    var recovered: Int?,
    var total: Int?
) : Parcelable
