package com.athentech.calendarview.data

data class HourlyData(
    var time:String,
    var subList:ArrayList<SubTimeData>?=null
)