package com.athentech.calendarview.events

import java.util.*

interface EventHandler {
    fun longPressed(date: Date)
    fun clicked(date: Date)
    fun dayViewClicked()
    fun timePressed(selectedDate:String,fromTime:String,endTime:String,duration:Int)
}