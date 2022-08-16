package com.example.openchallenge.model.response

import com.google.gson.annotations.SerializedName

data class DataTime(
    @SerializedName("year")val year :Int?,
    @SerializedName("month")val month:Int?,
    @SerializedName("day")val day:Int?

    )
