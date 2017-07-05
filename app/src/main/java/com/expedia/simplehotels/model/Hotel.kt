package com.expedia.simplehotels.model

import org.json.JSONObject

/**
 * Created by paulkite on 7/1/17.
 */

class Hotel(hotelJSON: JSONObject) {
    val name: String = hotelJSON.getString("hotelName")
    val imageUrlString: String = hotelJSON.getString("largeThumbnailUrl")
    val price: String = hotelJSON.getJSONObject("lowRateInfo")?.getString("priceToShowUsers") ?: "Unknown Price"
    var starRating: Double = hotelJSON.getDouble("hotelStarRating")
}