package com.athentech.srcalender

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.athentech.calendarview.events.EventHandler
import com.athentech.calendarview.util.getStringDate
import com.athentech.srcalender.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
         calenderView.updateDuration(10)
         calenderView.updateCalander()
         calenderView.apply {
             setCalendarNextDrawable(R.drawable.next_icon_ext)
             setCalendarPrevDrawable(R.drawable.previous_icon_ext)
             setNavBackground(R.drawable.shape_nav_cal_2)
         }
         calenderView.setEventHandler(object: EventHandler {
             override fun longPressed(date: Date) {

             }

             override fun clicked(date: Date) {
              localMessages(getStringDate(date),this@MainActivity)
             }

             override fun dayViewClicked() {

             }

             override fun timeLineLongPressed(fromTime: String, endTime: String) {
                  Log.d("calender_view","Start -$fromTime  End time - $endTime")
             }

         })
        }
    }
}