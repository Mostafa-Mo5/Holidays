package com.example.openchallenge.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.openchallenge.R
import com.example.openchallenge.adapters.HolidayAdapter
import com.example.openchallenge.databinding.FragmentHomeBinding
import com.example.openchallenge.model.network.State
import com.example.openchallenge.model.repository.HolidaysRepository
import com.example.openchallenge.model.response.Holiday
import com.example.openchallenge.model.response.HolidaysModel
import com.example.openchallenge.ui.base.BaseFragment
import com.example.openchallenge.util.Constants
import com.example.openchallenge.util.extensions.hide
import com.example.openchallenge.util.extensions.show
import com.example.openchallenge.util.interaction.HolidayInteractionListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<FragmentHomeBinding>(), HolidayInteractionListener {
    var listener = this
    private val holidaysData = HolidaysRepository()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requestHolidayData()
    }

    private fun requestHolidayData() {

        lifecycleScope.launch(Dispatchers.Main) {

            holidaysData.getHolidaysInfo().catch { showFailState() }.collect { state ->
                showResponseState(state)
            }
        }
    }

    private fun showResponseState(responseState: State<HolidaysModel>) {
        return when (responseState) {

            is State.Fail -> showFailState()
            is State.Loading -> showLoadingState()

            is State.Success -> showSuccessState(responseData = responseState.data.holidays?.holidays)
        }
    }

    private fun showFailState() {
        binding.apply {
            screenOnSuccess.hide()
            screenOnLoading.hide()
            screenOnFail.show()
        }
    }

    private fun showLoadingState() {
        binding.apply {
            screenOnLoading.show()
            screenOnSuccess.hide()
            screenOnFail.hide()
        }

    }

    private fun showSuccessState(responseData: List<Holiday>?) {
        binding.apply {
            screenOnLoading.hide()
            screenOnFail.hide()
            screenOnSuccess.show()
        }

        bindingHolidayDataToAdapter(responseData)
    }

    private fun bindingHolidayDataToAdapter(holidays: List<Holiday>?) {
        holidays?.let {
            val adapter = HolidayAdapter(holidays, listener)
            binding.recyclerViewHoliday.adapter = adapter
        }
    }

    override fun onClickItem(holiday: Holiday) {

        val bundle = Bundle().apply {
            putParcelable(Constants.KeysValue.HOLIDAY, holiday)
        }

        val detailsFragment = DetailsFragment().apply { arguments = bundle }

        this.activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragment_container, detailsFragment)
            addToBackStack(null)
        }?.commit()
    }
}