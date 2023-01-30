package com.athentech.srcalender

import java.util.Date
import java.util.EventListener

data class CalenderData(
    var dateList: MutableList<Date>?=null,
    var eventsList: MutableList<EventsItems>?=null,
    var isSelected:Boolean=false,
    var isEnabled:Boolean
)
data class EventsItems(
    var eventTitle:String?=null,
    var time:Date?=null
)