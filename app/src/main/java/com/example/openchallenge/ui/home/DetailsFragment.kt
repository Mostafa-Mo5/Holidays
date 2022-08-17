package com.example.openchallenge.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.openchallenge.databinding.FragmentDetailsBinding
import com.example.openchallenge.model.response.Holiday
import com.example.openchallenge.ui.base.BaseFragment
import com.example.openchallenge.util.Constants
import com.example.openchallenge.util.HolidayInteractionListener
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*


class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailsBinding =
        FragmentDetailsBinding::inflate

    var holiday: Holiday? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        holiday = arguments?.getParcelable(Constants.KeysValue.HOLIDAY)
        onBindingDataHolidays(holiday)
    }

    private fun onBindingDataHolidays(holiday: Holiday?) {
        val currentDate = LocalDateTime.now()

        val holidayDate = holiday?.date?.dataTime?.run { LocalDate.of(year, month, day) }
            ?.minusYears(currentDate.year.toLong())
            ?.minusMonths(currentDate.monthValue.toLong())
            ?.minusDays(currentDate.dayOfWeek.value.toLong())


        binding.apply {
            nameOfHoliday.text = holiday?.name
            country.text = holiday?.country?.name
            date.text = holidayDate.toString()
        }
        Log.d("TESTING", "$holidayDate - ${holiday?.date?.dateFormat}")
    }

}