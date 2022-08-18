package com.example.openchallenge.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Date(
    @SerializedName("iso") val dateFormat:String?,
    @SerializedName("datetime") val date:DataTime?
): Parcelable
