package com.example.openchallenge.util.extensions

import android.view.View
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}



