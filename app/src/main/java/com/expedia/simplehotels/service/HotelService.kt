package com.expedia.simplehotels.service

import com.expedia.simplehotels.model.Destination
import com.expedia.simplehotels.model.Hotel
import com.expedia.simplehotels.request.RequestTask
import com.expedia.simplehotels.request.URLRequest
import org.json.JSONObject

/**
 * Created by paulkite on 7/1/17.
 */

open class HotelService {
    open fun requestHotelsFor(destination: Destination, completion: (ArrayList<Hotel>) -> Unit) {
        val request: URLRequest?

        when (destination) {
            Destination.CHICAGO -> request = URLRequest(Destination.CHICAGO.urlString)
            Destination.SAN_FRANCISCO -> request = URLRequest(Destination.SAN_FRANCISCO.urlString)
        }

        val task = RequestTask(request) {
            val hotelObjects = it?.getJSONArray("hotels") ?: throw Exception("Could not create hotelObjects array.")

            val hotels = ArrayList<Hotel>()

            (0..(hotelObjects.length() - 1))
                    .map { hotelObjects[it] as JSONObject }
                    .mapTo(hotels) { Hotel(it) }

            completion(hotels)
        }

        task.execute()
    }
}
