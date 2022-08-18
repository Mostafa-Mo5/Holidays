package com.example.openchallenge.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.openchallenge.R
import com.example.openchallenge.databinding.ItemHolidayBinding
import com.example.openchallenge.model.response.Holiday
import com.example.openchallenge.util.interaction.HolidayInteractionListener

class HolidayAdapter(
    private val list: List<Holiday>,
    private val listener: HolidayInteractionListener
) : RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolidayViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_holiday, parent, false)
        return HolidayViewHolder(view)
    }

    override fun onBindViewHolder(holder: HolidayViewHolder, position: Int) {
        val currentHoliday = list[position]

        holder.binding.apply {
            nameOfHoliday.text = currentHoliday.name
            date.text = currentHoliday.date?.dateFormat?.take(10)

            root.setOnClickListener {
                listener.onClickItem(currentHoliday)
            }

        }

    }

    override fun getItemCount(): Int = list.size


    class HolidayViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemHolidayBinding.bind(viewItem)
    }
}