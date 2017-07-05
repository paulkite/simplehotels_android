package com.expedia.simplehotels.viewModel

import com.expedia.simplehotels.model.Hotel

/**
 * Created by paulkite on 7/2/17.
 */

class HotelItemViewModel(hotel: Hotel) {
    val displayName = hotel.name
    val displayPrice = hotel.price
}
