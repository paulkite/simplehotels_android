package com.expedia.simplehotels.viewModel

import android.content.Context
import com.expedia.simplehotels.model.Destination
import com.expedia.simplehotels.model.Hotel
import com.expedia.simplehotels.providers.HotelImageProvider
import com.expedia.simplehotels.service.HotelService

/**
 * Created by paulkite on 7/1/17.
 */

class HotelListViewModel(val service: HotelService, private val context: Context) {
    var hotels = ArrayList<Hotel>()
        private set

    var hotelsDidChangeCallback: (() -> Unit)? = null
    var didSelectHotelCallback: ((HotelViewModel) -> Unit)? = null

    var destination: Destination = Destination.SAN_FRANCISCO
        set(value) {
            field = value
            service.requestHotelsFor(value) {
                hotels = it
                hotelsDidChangeCallback?.invoke()
            }
        }

    init {
        this.destination = destination
    }

    fun getItemAt(index: Int): Hotel? {
        if (index < hotels.size) {
            return hotels[index]
        }

        return null
    }

    fun hotelSelectedAt(position: Int) {
        if (position < hotels.size) {
            val hotel = hotels[position]
            val imageProvider = HotelImageProvider(hotel.imageUrlString, context)
            didSelectHotelCallback?.invoke(HotelViewModel(hotel, imageProvider))
        }
    }
}
