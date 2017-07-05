package com.expedia.simplehotels

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.expedia.simplehotels.providers.ImageProvider
import com.expedia.simplehotels.viewModel.HotelViewModel
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RuntimeEnvironment
import kotlin.test.assertEquals

/**
 * Created by paulkite on 7/4/17.
 */

@RunWith(RobolectricRunner::class)
class HotelViewModelTests {
    val context: Context = RuntimeEnvironment.application

    @Test
    fun testHotelViewModelFieldEquality() {
        val hotel = TestHelper.sfHotel
        val imageProvider = TestImageProvider(hotel.imageUrlString, context)
        val viewModel = HotelViewModel(hotel, imageProvider)

        val expectedImage = BitmapFactory.decodeResource(context.resources, R.drawable.test_hotel_image)

        assertEquals(viewModel.displayHotelName, "A San Francisco Hotel")
        assertEquals(viewModel.displayHotelImage.width, expectedImage.width)
        assertEquals(viewModel.displayHotelImage.height, expectedImage.height)
        assertEquals(viewModel.displayHotelImage.byteCount, expectedImage.byteCount)
        assertEquals(viewModel.displayStarRating, 4.0)
        assertEquals(viewModel.displayPrice, "100")
    }
}

class TestImageProvider(imagePath: String, private val context: Context): ImageProvider(imagePath, context) {
    override val imageSchemeHostString = ""

    override fun getImage(): Bitmap? {
        return BitmapFactory.decodeResource(context.resources, R.drawable.test_hotel_image)
    }
}
