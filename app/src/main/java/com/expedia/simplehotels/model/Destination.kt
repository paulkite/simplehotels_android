package com.expedia.simplehotels.model

/**
 * Created by paulkite on 7/1/17.
 */

enum class Destination(val urlString: String) {
    CHICAGO("https://techblog.expedia.com/utility/chicago-hotels.json"),
    SAN_FRANCISCO("https://techblog.expedia.com/utility/san-francisco-hotels.json")
}
