package com.example.openchallenge.model.response

import com.google.gson.annotations.SerializedName

data class HolidaysModel(
    @SerializedName("meta") val meta :Meta,
    @SerializedName("response") val dataResponse:Holidays?
)