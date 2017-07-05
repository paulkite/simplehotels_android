package com.expedia.simplehotels.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.expedia.simplehotels.R
import com.expedia.simplehotels.viewHolders.HotelItemViewHolder
import com.expedia.simplehotels.viewModel.HotelItemViewModel
import com.expedia.simplehotels.viewModel.HotelListViewModel

/**
 * Created by paulkite on 7/2/17.
 */

class HotelListAdapter(private val viewModel: HotelListViewModel): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        viewModel.hotelsDidChangeCallback = {
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when (holder) {
            is HotelItemViewHolder -> {
                val hotel = viewModel.getItemAt(position)

                if (hotel != null) {
                    holder.bind(HotelItemViewModel(hotel))

                    holder.itemView.setOnClickListener {
                        viewModel.hotelSelectedAt(position)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return viewModel.hotels.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hotel_item_card, parent, false)

        return HotelItemViewHolder(view)
    }
}
