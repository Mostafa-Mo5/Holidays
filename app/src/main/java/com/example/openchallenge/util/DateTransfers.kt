package com.example.openchallenge.util

import com.example.openchallenge.model.response.Holiday
import java.time.LocalDate
import java.time.LocalDateTime

class DateTransfers(val holiday: Holiday?) {

    fun remaining(): String {
        val currentDate = LocalDateTime.now()
        val remainingDate =holiday?.date?.date?.run { LocalDate.of(year, month, day) }
            ?.minusYears(currentDate.year.toLong())
            ?.minusMonths(currentDate.monthValue.toLong())
            ?.minusDays(currentDate.dayOfWeek.value.toLong())

        return remainingDate.toString().drop(3)


    }
}