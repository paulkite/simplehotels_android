package com.expedia.simplehotels

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.expedia.simplehotels.utils.bindView
import com.expedia.simplehotels.viewModel.HotelViewModel

class HotelDetailActivity : AppCompatActivity() {
    val imageView: ImageView by bindView<ImageView>(R.id.image_view)
    val hotelNameTextView: TextView by bindView<TextView>(R.id.hotel_name_text_view)
    val hotelPriceTextView: TextView by bindView<TextView>(R.id.hotel_price_text_view)
    val hotelRatingBar: RatingBar by bindView<RatingBar>(R.id.hotel_rating_bar)
    val hotelMapButton: Button by bindView<Button>(R.id.hotel_map_button)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_detail)

        val viewModel = intent.extras.get("viewModel") as HotelViewModel

        viewModel.displayHotelImageDidPopulate = {
            imageView.setImageBitmap(viewModel.displayHotelImage)
        }

        hotelNameTextView.text = viewModel.displayHotelName
        hotelPriceTextView.text = viewModel.displayPrice
        hotelRatingBar.rating = viewModel.displayStarRating.toFloat()
    }
}
