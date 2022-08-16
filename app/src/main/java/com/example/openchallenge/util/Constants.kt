package com.example.openchallenge.util

object Constants {

    object HttpUrl {
        const val SCHEME = "https"
        const val HOST = "calendarific.com"
        const val PATH_SEGMENTS = "api/v2/holidays"

        object Keys {
            const val COUNTRY = "country"
            const val YEAR = "year"
            const val API_KEY = "api_key"
        }

        object Values {
            const val COUNTRY = "IQ"
            const val YEAR = "2022"
            const val API_KEY = "1944cee2bdb64e890cfff6e5e3be5f98edca3e8a"
        }
    }
}