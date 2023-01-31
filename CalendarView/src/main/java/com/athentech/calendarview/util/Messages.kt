package com.athentech.calendarview.util

import android.content.Context
import android.widget.Toast

fun localMessages(msg:String,context: Context){
    Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
}