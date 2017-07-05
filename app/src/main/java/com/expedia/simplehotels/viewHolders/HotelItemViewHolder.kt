package com.expedia.simplehotels.viewHolders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.expedia.simplehotels.R
import com.expedia.simplehotels.utils.bindView
import com.expedia.simplehotels.viewModel.HotelItemViewModel

/**
 * Created by paulkite on 7/2/17.
 */

class HotelItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val hotelNameTextView: TextView by bindView<TextView>(R.id.hotel_name)
    val hotelPriceTextView: TextView by bindView<TextView>(R.id.hotel_price)

    fun bind(viewModel: HotelItemViewModel) {
        hotelNameTextView.text = viewModel.displayName
        hotelPriceTextView.text = viewModel.displayPrice
    }
}
