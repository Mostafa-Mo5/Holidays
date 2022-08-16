package com.example.openchallenge.model.response

import com.google.gson.annotations.SerializedName


data class Date(
    @SerializedName("iso") val dateAtFormat:String?,
    @SerializedName("datetime") val dataTime:DataTime?
)
