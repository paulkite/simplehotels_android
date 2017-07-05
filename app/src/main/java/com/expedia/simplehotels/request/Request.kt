package com.expedia.simplehotels.request

import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by paulkite on 7/1/17.
 */

abstract class Request(val urlString: String) {
    abstract fun getURLConnection(): HttpURLConnection
}

class URLRequest(urlString: String) : Request(urlString) {
    override fun getURLConnection(): HttpURLConnection {
        val url = URL(urlString)
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"

        return connection
    }
}