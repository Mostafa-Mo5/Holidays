package com.example.openchallenge.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.openchallenge.HolidayAdapter
import com.example.openchallenge.R
import com.example.openchallenge.databinding.FragmentHomeBinding
import com.example.openchallenge.model.network.State
import com.example.openchallenge.model.repository.HolidaysRepository
import com.example.openchallenge.model.response.Holiday
import com.example.openchallenge.model.response.HolidaysModel
import com.example.openchallenge.ui.base.BaseFragment
import com.example.openchallenge.util.Constants
import com.example.openchallenge.util.HolidayInteractionListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime


class HomeFragment : BaseFragment<FragmentHomeBinding>(),HolidayInteractionListener {
    var listener =this
    private val holidaysData = HolidaysRepository()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requestHolidayData()
    }

    private fun requestHolidayData() {

        lifecycleScope.launch(Dispatchers.Main) {

            holidaysData.getBookInfo().collect { state ->
                showResponseState(state)
            }
        }
    }

    private fun showResponseState(responseState: State<HolidaysModel>) {
        return when (responseState) {

            is State.Fail -> showFailState(responseState.message)
            is State.Loading -> showLoadingState()

            is State.Success -> showSuccessState(holidays = responseState.data.dataResponse?.holidays)
        }
    }

    private fun showFailState(massage: String) {
        Log.i("HOMEFRAGMENT", "FAIL $massage")
    }

    private fun showLoadingState() {

    }

    private fun showSuccessState(holidays: List<Holiday>?) {
        Log.i("HOMEFRAGMENT", "success $holidays")
        binding.apply {


            holidays?.let {
                val adapter = HolidayAdapter(holidays,listener)
                binding.recyclerViewHoliday.adapter = adapter
            }
        }
    }

    override fun onClickItem(holiday: Holiday) {

        val bundle = Bundle().apply {
            putParcelable(Constants.KeysValue.HOLIDAY,holiday)
        }
        val detailsFragment = DetailsFragment().apply { arguments=bundle }
        this.activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragment_container,detailsFragment)
            addToBackStack(null)
        }?.commit()
    }
}