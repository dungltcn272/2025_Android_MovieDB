package com.nhom4.androidmoviedb.core.utils

import android.graphics.BitmapFactory
import android.widget.ImageView
import com.nhom4.androidmoviedb.R
import java.net.HttpURLConnection
import java.net.URL

fun loadImageFromUrl(imageView: ImageView, url: String) {
    Thread {
        try {
            val connection = URL(url).openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val inputStream = connection.inputStream
            val bitmap = BitmapFactory.decodeStream(inputStream)

            imageView.post {
                imageView.setImageBitmap(bitmap)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            imageView.post {
                imageView.setImageResource(R.drawable.ic_launcher_foreground)
            }
        }
    }.start()
}
