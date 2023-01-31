package com.athentech.calendarview.util

import java.text.SimpleDateFormat
import java.util.*

fun isGreaterDate(date: Date, today: Date):Boolean{
    return date.before(today)
}
fun getDayNameOfTheDay(date: Date): String {
    val sdf = SimpleDateFormat("EEE")
    return sdf.format(date)

}
fun getStringDate(date: Date):String{
   val sdf= SimpleDateFormat("dd MMM yyyy")
    return sdf.format(date)
}