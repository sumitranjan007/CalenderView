package com.athentech.srcalender

import java.util.Date
import java.util.EventListener

data class CalenderData(
    var dateList: Date?=null,
    var eventsList: MutableList<EventsData>?=null,
    var isSelected:Boolean=false,
    var isEnabled:Boolean
)
