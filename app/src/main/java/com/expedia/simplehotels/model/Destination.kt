package com.expedia.simplehotels.model

/**
 * Created by paulkite on 7/1/17.
 */

enum class Destination(val urlString: String) {
    CHICAGO("https://raw.githubusercontent.com/paulkite/simplehotels_android/master/responses/chicago-hotels.json"),
    SAN_FRANCISCO("https://raw.githubusercontent.com/paulkite/simplehotels_android/master/responses/san-francisco-hotels.json")
}
