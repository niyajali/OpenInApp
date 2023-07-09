package com.niyaj.openinapp.feature.utils

import java.util.Calendar

object Extension {

    fun getGreetingHour(): String {
        val calendar = Calendar.getInstance()

        return when(calendar.get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> "Good Morning"
            in 12..15 -> "Good Afternoon"
            in 16..20 -> "Good Evening"
            in 21..23 -> "Good Night"
            else -> "Hello!"
        }
    }
}