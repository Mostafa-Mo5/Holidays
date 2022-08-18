package com.example.openchallenge.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.openchallenge.databinding.FragmentDetailsBinding
import com.example.openchallenge.model.response.Holiday
import com.example.openchallenge.ui.base.BaseFragment
import com.example.openchallenge.util.Constants
import com.example.openchallenge.util.DateTransfers


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


        binding.apply {
            nameOfHoliday.text = holiday?.name
            country.text = holiday?.country?.name
            remaining.text = DateTransfers(holiday).remaining()
            description.text = holiday?.description.toString()
            date.text = holiday?.date?.dateFormat?.take(10)
            type.text = holiday?.type?.get(Constants.CURRENT_TYPE).toString()

        }

    }

}