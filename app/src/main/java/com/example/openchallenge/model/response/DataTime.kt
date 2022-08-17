package com.example.openchallenge.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataTime(
    @SerializedName("year") val year: Int,
    @SerializedName("month") val month: Int,
    @SerializedName("day") val day: Int
) : Parcelable
