package com.expedia.simplehotels

import com.expedia.simplehotels.model.Hotel
import org.json.JSONObject
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by paulkite on 6/30/17.
 */
class HotelTests {
    @Test
    fun testHotelNameEquality() {
        val hotel = Hotel(TestHelper.sfJsonObject)

        assertEquals(hotel.name, "A San Francisco Hotel")
    }

    @Test
    fun testHotelPriceEquality() {
        val hotel = Hotel(TestHelper.sfJsonObject)

        assertEquals(hotel.price, "100")
    }

    @Test
    fun testHotelStarRatingEquality() {
        val hotel = Hotel(TestHelper.sfJsonObject)

        assertEquals(hotel.starRating, 4.0)
    }

    @Test
    fun testHotelImageUrlStringEquality() {
        val hotel = Hotel(TestHelper.sfJsonObject)

        assertEquals(hotel.imageUrlString, "/image.jpg")
    }
}
