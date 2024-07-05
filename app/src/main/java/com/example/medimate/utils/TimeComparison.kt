package com.example.medimate.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun timeComparison(reminderTime: String): String {
    val currentTime = LocalTime.now()

    val formatter = DateTimeFormatter.ofPattern("hh:mm a")

    val otherTime = LocalTime.parse(reminderTime, formatter)

    val comparison = currentTime.compareTo(otherTime)

    return if (comparison > 0) return "Skipped" else "Pending"
}