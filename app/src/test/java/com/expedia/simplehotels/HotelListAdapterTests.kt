package com.expedia.simplehotels

import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.expedia.simplehotels.viewModel.HotelListViewModel
import com.expedia.simplehotels.adapters.HotelListAdapter
import com.expedia.simplehotels.viewHolders.HotelItemViewHolder
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RuntimeEnvironment
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by paulkite on 7/1/17.
 */

@RunWith(RobolectricRunner::class)
class HotelListAdapterTests {
    @Test
    fun testGetItemCount() {
        val adapter = HotelListAdapter(HotelListViewModel(TestHotelService()))

        assertEquals(adapter.itemCount, 1)
    }

    @Test
    fun testOnCreateViewHolderReturnsHotelItemViewHolder() {
        val holder = createAndBindViewHolder(0)

        assertTrue { holder is HotelItemViewHolder }
    }

    @Test
    fun testBoundTextViewValues() {
        val holder = createAndBindViewHolder(0) as HotelItemViewHolder

        assertEquals(holder.hotelNameTextView.text, "A San Francisco Hotel")
        assertEquals(holder.hotelPriceTextView.text, "100")
    }

    private fun createAndBindViewHolder(position: Int): RecyclerView.ViewHolder {
        val adapter = HotelListAdapter(HotelListViewModel(TestHotelService()))
        val holder = adapter.createViewHolder(LinearLayout(RuntimeEnvironment.application), 0)
        adapter.bindViewHolder(holder, position)

        return holder
    }
}
