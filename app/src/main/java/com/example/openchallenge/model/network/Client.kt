package com.example.openchallenge.model.network

import android.util.Log
import com.example.openchallenge.model.response.HolidaysModel
import com.example.openchallenge.util.Constants
import com.google.gson.Gson
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

object Client {

    private val okHttpClient = OkHttpClient()
    private val gson = Gson()


    fun requestHolidayData(): State<HolidaysModel> {
        val httpUrl = buildHttpUrl()
        val request = buildRequest(httpUrl)
        Log.i("CLIENT",httpUrl.toString())

        val response = executeRequest(request)


        return if (response.isSuccessful) {

            val jasonString = response.body!!.string()

            Log.i("CLIENT", "$jasonString")
            val holidays = gson.fromJson(jasonString, HolidaysModel::class.java)
            Log.i("CLIENT", "${holidays}")
            State.Success(holidays)


        } else {
            Log.i("CLIENT", "${response.message} WESAM")
            State.Fail(response.message)
        }
    }

    private fun buildHttpUrl() = with(Constants.HttpUrl) {
        val keys = Constants.HttpUrl.Keys
        val values = Constants.HttpUrl.Values

        HttpUrl.Builder()
            .scheme(SCHEME)
            .host(HOST)
            .addPathSegments(PATH_SEGMENTS)
            .addQueryParameter(keys.COUNTRY, values.COUNTRY)
            .addQueryParameter(keys.YEAR, values.YEAR)
            .addQueryParameter(keys.API_KEY, values.API_KEY)
            .build()

    }


    private fun buildRequest(httpUrl:HttpUrl) = Request.Builder().url(httpUrl).build()

    private fun executeRequest(request: Request) = okHttpClient.newCall(request).execute()
}