package com.example.covidapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TestModel(
    @SerializedName("1M_pop") var one_m_pop: String?,
    var total: Int?
) : Parcelable
