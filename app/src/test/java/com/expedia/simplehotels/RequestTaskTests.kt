package com.expedia.simplehotels

import com.expedia.simplehotels.request.Request
import com.expedia.simplehotels.request.RequestTask
import org.json.JSONObject
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.shadows.ShadowAsyncTask
import java.io.*
import kotlin.test.assertEquals
import java.net.HttpURLConnection
import java.net.URL
import kotlin.test.assertNotNull

/**
 * Created by paulkite on 6/30/17.
 */

@RunWith(RobolectricRunner::class)
class RequestTaskTests {
    @Test
    fun testUrlEquality() {
        val request = TestURLRequest("https://somehost.com")
        val task = RequestTask(request)
        assertEquals(task.urlString, "https://somehost.com")
    }

    @Test
    fun testResponseReturnsValidJSONObject() {
        val provider = TestURLRequest("https://somehost.com")
        var jsonObject: JSONObject? = null

        val task = RequestTask(provider, completion = { jsonObject = it })

        task.execute()

        assertNotNull(jsonObject)
        assertEquals(jsonObject?.getString("name"), "A Hotel Name")
        assertEquals(jsonObject?.getJSONObject("lowRateInfo")?.getString("priceToShowUsers"), "100")
    }
}

class TestURLRequest(urlString: String) : Request(urlString) {
    override fun getURLConnection(): HttpURLConnection {
        val url = URL(urlString)

        return TestHttpURLConnection(url)
    }
}

class TestHttpURLConnection(u: URL?) : HttpURLConnection(u) {
    override fun disconnect() {}

    override fun connect() {}

    override fun usingProxy(): Boolean {
        return false
    }

    override fun getInputStream(): InputStream {
        val jsonData= "{\"name\": \"A Hotel Name\", \"lowRateInfo\":{\"priceToShowUsers\": \"100\"}}".toByteArray()

        return jsonData.inputStream()
    }
}
