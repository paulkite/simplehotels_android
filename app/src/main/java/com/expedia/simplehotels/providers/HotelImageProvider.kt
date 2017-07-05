package com.expedia.simplehotels.providers

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target

/**
 * Created by paulkite on 7/4/17.
 */

class HotelImageProvider(private val imagePath: String, private val context: Context): ImageProvider(imagePath, context), Target {
    override val imageSchemeHostString = "https://media.expedia.com"
    private lateinit var completion: (Bitmap?) -> Unit

    override fun getImage(completion: (Bitmap?) -> Unit) {
        this.completion = completion

        Picasso.with(context).load(Uri.parse(imageSchemeHostString + imagePath)).into(this)
    }

    override fun onBitmapFailed(errorDrawable: Drawable?) {
        print("Error")
    }
    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
        print("Started")
    }
    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
        completion(bitmap)
    }
}