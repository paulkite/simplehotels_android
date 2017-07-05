package com.expedia.simplehotels

import com.expedia.simplehotels.model.Destination
import com.expedia.simplehotels.model.Hotel
import com.expedia.simplehotels.service.HotelService
import com.expedia.simplehotels.viewModel.HotelListViewModel
import org.json.JSONObject
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

/**
 * Created by paulkite on 7/1/17.
 */

class HotelListViewModelTests {
    @Test
    fun testHotelsPopulatedOnInit() {
        val viewModel = HotelListViewModel(TestHotelService())

        assertEquals(viewModel.hotels.size, 1)
    }

    @Test
    fun testHotelsPopulatedWhenDestinationChanges() {
        val viewModel = HotelListViewModel(TestHotelService())

        assertEquals(viewModel.getItemAt(0)?.name, TestHelper.sfHotel.name)
        assertEquals(viewModel.getItemAt(0)?.price, TestHelper.sfHotel.price)

        viewModel.destination = Destination.CHICAGO

        assertEquals(viewModel.destination, Destination.CHICAGO)
        assertEquals(viewModel.getItemAt(0)?.name, TestHelper.chicagoHotel.name)
        assertEquals(viewModel.getItemAt(0)?.price, TestHelper.chicagoHotel.price)
    }

    @Test
    fun testGetItemAtForValidIndex() {
        val viewModel = HotelListViewModel(TestHotelService())

        assertEquals(viewModel.getItemAt(0)?.name, TestHelper.sfHotel.name)
        assertEquals(viewModel.getItemAt(0)?.price, TestHelper.sfHotel.price)
    }

    @Test
    fun testGetItemAtForInvalidIndex() {
        val viewModel = HotelListViewModel(TestHotelService())

        assertNull(viewModel.getItemAt(1))
    }
}

class TestHotelService: HotelService() {
    override fun requestHotelsFor(destination: Destination, completion: (ArrayList<Hotel>) -> Unit) {
        val chicagoHotels = arrayListOf<Hotel>(Hotel(TestHelper.chicagoJsonObject))
        val sfHotels = arrayListOf<Hotel>(Hotel(TestHelper.sfJsonObject))

        when (destination) {
            Destination.CHICAGO -> completion(chicagoHotels)
            Destination.SAN_FRANCISCO -> completion(sfHotels)
        }
    }
}
