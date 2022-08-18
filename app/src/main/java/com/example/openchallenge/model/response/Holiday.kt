package com.example.openchallenge.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Holiday(
    @SerializedName("name")val name :String?,
    @SerializedName("description")val description :String?,
    @SerializedName("country") val country:Country?,
    @SerializedName("date") val date :Date?,
    @SerializedName("type") val type :List<String>?,
):Parcelable