package com.example.openchallenge.util

import com.example.openchallenge.model.response.Holiday

interface HolidayInteractionListener {
    fun onClickItem(holiday: Holiday)
}