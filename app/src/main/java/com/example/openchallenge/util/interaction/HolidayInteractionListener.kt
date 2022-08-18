package com.example.openchallenge.util.interaction

import com.example.openchallenge.model.response.Holiday

interface HolidayInteractionListener {
    fun onClickItem(holiday: Holiday)
}