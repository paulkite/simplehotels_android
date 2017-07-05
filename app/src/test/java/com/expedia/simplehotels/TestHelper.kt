package com.expedia.simplehotels

import com.expedia.simplehotels.model.Hotel
import org.json.JSONObject

/**
 * Created by paulkite on 7/2/17.
 */
class TestHelper {
    companion object {
        val sfJson = "{\"hotelName\": \"A San Francisco Hotel\", \"lowRateInfo\":{\"priceToShowUsers\": \"100\"}, \"hotelStarRating\": \"4.0\", \"largeThumbnailUrl\": \"/image.jpg\"}"
        val chicagoJson = "{\"hotelName\": \"A Chicago Hotel\", \"lowRateInfo\":{\"priceToShowUsers\": \"100\"}, \"hotelStarRating\": \"4.0\", \"largeThumbnailUrl\": \"/image.jpg\"}"
        val sfJsonObject = JSONObject(sfJson)
        val chicagoJsonObject = JSONObject(chicagoJson)
        val sfHotel = Hotel(sfJsonObject)
        var chicagoHotel = Hotel(chicagoJsonObject)
    }
}