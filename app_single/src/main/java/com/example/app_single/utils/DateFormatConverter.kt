package com.example.app_single.utils

import java.text.SimpleDateFormat
import java.util.*


fun convertToNormalDate(date: String): String {
    val date = SimpleDateFormat("yyyy-MM-dd", Locale.UK).parse(date).time
    val format = SimpleDateFormat("dd.MM.yyyy", Locale.UK)
    return format.format(date)
}