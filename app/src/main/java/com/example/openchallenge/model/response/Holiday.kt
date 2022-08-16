package com.example.openchallenge.model.response

import com.google.gson.annotations.SerializedName

data class Holiday(
    @SerializedName("name")val name :String?,
    @SerializedName("description")val description :String?,
    @SerializedName("country") val country:Country?,
    @SerializedName("date") val date :Date?,
    @SerializedName("type") val type :List<String>?,
)