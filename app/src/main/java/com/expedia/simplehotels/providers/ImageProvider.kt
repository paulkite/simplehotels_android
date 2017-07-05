package com.expedia.simplehotels.providers

import android.content.Context
import android.graphics.Bitmap

/**
 * Created by paulkite on 7/4/17.
 */

abstract class ImageProvider(private val imagePath: String, private val context: Context) {
    protected abstract val imageSchemeHostString: String
    abstract fun getImage(completion: (Bitmap?) -> Unit)
}
