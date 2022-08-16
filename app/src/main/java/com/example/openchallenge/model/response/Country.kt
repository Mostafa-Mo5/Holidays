package com.example.openchallenge.model.response

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("id") val id :String? ,
    @SerializedName("name") val name :String?,

)
