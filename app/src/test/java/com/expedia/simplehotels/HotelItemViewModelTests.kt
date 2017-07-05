package com.expedia.simplehotels

import com.expedia.simplehotels.viewModel.HotelItemViewModel
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by paulkite on 7/2/17.
 */

class HotelItemViewModelTests {
    @Test
    fun testInitEquality() {
        val viewModel = HotelItemViewModel(TestHelper.chicagoHotel)

        assertEquals(viewModel.displayName, "A Chicago Hotel")
        assertEquals(viewModel.displayPrice, "100")
    }
}
