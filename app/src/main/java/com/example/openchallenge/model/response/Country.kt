package com.example.openchallenge.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    @SerializedName("id") val id :String? ,
    @SerializedName("name") val name :String?,

): Parcelable
