package com.expedia.simplehotels.viewModel

import android.graphics.Bitmap
import com.expedia.simplehotels.model.Hotel
import com.expedia.simplehotels.providers.ImageProvider
import java.io.Serializable

/**
 * Created by paulkite on 7/4/17.
 */

class HotelViewModel(hotel: Hotel, imageProvider: ImageProvider): Serializable {
    val displayHotelName: String = hotel.name
    lateinit var displayHotelImage: Bitmap
        private set
    val displayStarRating: Double = hotel.starRating
    val displayPrice: String = hotel.price

    var displayHotelImageDidPopulate: (() -> Unit)? = null

    init {
        imageProvider.getImage { image ->
            displayHotelImage = image ?: Bitmap.createBitmap(100, 100, Bitmap.Config.ALPHA_8)
            displayHotelImageDidPopulate?.invoke()
        }
    }
}
