package com.athentech.srcalender

import android.content.Context
import android.util.Log
import android.widget.Toast

fun localMessages(msg:String,context: Context){
    Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
}
fun localLog(msg: String){
    Log.d("calender_view",msg)
}