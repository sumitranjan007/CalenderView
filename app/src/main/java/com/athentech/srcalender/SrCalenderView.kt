package com.athentech.srcalender

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import java.util.Calendar

class SrCalenderView constructor(context:Context?, attributeSet: AttributeSet?):LinearLayout(context,attributeSet) {
    private var dateFormat:String?=null
    private var DATE_FORMAT="MMM yyyy"
    private var currentDate=Calendar.getInstance()
    private var eventHandle:EventHandler?=null
    //How many Days to Show ,default to six weeks,42 days
    private val DAYS_COUNT = 42
    //Internal; components
    private var header:LinearLayout?=null
}