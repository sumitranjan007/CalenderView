package com.athentech.calendarview.data

import java.util.*

data class CalenderData(
    var dateList: Date?=null,
    var eventsList: MutableList<EventsData>?=null,
    var isSelected:Boolean=false,
    var isEnabled:Boolean
)

