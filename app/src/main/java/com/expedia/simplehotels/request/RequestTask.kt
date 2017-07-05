package com.expedia.simplehotels.request

import android.os.AsyncTask
import org.json.JSONObject
import java.io.*

/**
 * Created by paulkite on 7/1/17.
 */


class RequestTask(val request: Request, val completion: ((JSONObject?) -> Unit)? = null): AsyncTask<Request, Int, JSONObject>() {
    val urlString = request.urlString

    override fun doInBackground(vararg params: Request?): JSONObject {
        val connection = request.getURLConnection()
        var response = ""

        try {
            var connectionInputStream = connection.inputStream
            val inputStream = BufferedInputStream(connectionInputStream)
            response = convertStreamToString(inputStream)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            connection.disconnect()
        }

        return JSONObject(response)
    }

    override fun onPostExecute(result: JSONObject?) {
        super.onPostExecute(result)

        completion?.invoke(result)
    }

    private fun convertStreamToString(inputStream: InputStream): String {
        val reader = BufferedReader(InputStreamReader(inputStream))
        val builder = StringBuilder()

        try {
            for (line in reader.lines()) {
                builder.append(line).append('\n')
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                inputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        return builder.toString()
    }
}