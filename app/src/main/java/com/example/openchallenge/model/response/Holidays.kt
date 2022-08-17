package com.example.openchallenge.model.response

import com.google.gson.annotations.SerializedName

data class Holidays(
    @SerializedName("holidays") val holidays: List<Holiday>?
)