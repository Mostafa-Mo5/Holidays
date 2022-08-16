package com.example.openchallenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.openchallenge.databinding.ItemHolidayBinding
import com.example.openchallenge.model.response.Holiday

class HolidayAdapter(val list: List<Holiday>):RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolidayViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_holiday,parent,false)
        return HolidayViewHolder(view)
    }

    override fun onBindViewHolder(holder: HolidayViewHolder, position: Int) {
        val list =list[position]
        holder.binding.apply {
            nameOfHoliday.text=list.name
            country.text=list.country.toString()
            date.text=list.date?.dateAtFormat

        }

    }

    override fun getItemCount():Int=list.size



    class HolidayViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemHolidayBinding.bind(viewItem)
    }
}