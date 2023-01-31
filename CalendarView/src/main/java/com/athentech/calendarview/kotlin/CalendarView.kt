package com.athentech.calendarview.kotlin

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.athentech.calendarview.R
import com.athentech.calendarview.adapters.CalenderAdapter
import com.athentech.calendarview.adapters.HourlyAdapter
import com.athentech.calendarview.data.CalenderData
import com.athentech.calendarview.data.EventsData
import com.athentech.calendarview.data.HourlyData
import com.athentech.calendarview.data.SubTimeData
import com.athentech.calendarview.databinding.CalendarViewLayoutBinding
import com.athentech.calendarview.events.EventHandler
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class CalendarView constructor(context: Context?, attributeSet: AttributeSet?):
    LinearLayout(context,attributeSet) {
    private var dateFormat:String?=null
    private var DATE_FORMAT="MMM yyyy"
    private var currentDate= Calendar.getInstance()
    private var eventHandle:EventHandler?=null
    //How many Days to Show ,default to six weeks,42 days
    private val DAYS_COUNT = 42
    private var durationGlobal=10
    private lateinit var binding:CalendarViewLayoutBinding
    private lateinit var calanderAdapter: CalenderAdapter
    private lateinit var howerlyAdapter: HourlyAdapter
    init {
        initUiControls(context,attributeSet)
    }
    constructor(context: Context?, attributeSet: AttributeSet?, defStyle:Int):this(context,attributeSet){
        initUiControls(context,attributeSet)
    }
    private fun initUiControls(context: Context?, attributeSet: AttributeSet?){
        binding= CalendarViewLayoutBinding.inflate(LayoutInflater.from(context),this,true)

        binding.apply {
            calenderRecycler.layoutManager= GridLayoutManager(context,7)
            calanderAdapter= CalenderAdapter(context!!,object:CalenderAdapter.CalenderListner{
                override fun dateClicked(date: Date) {
                    eventHandle!!.clicked(date)
                }

            })
            calenderRecycler.adapter=calanderAdapter
            //Howerly
            howerlyRecycler.layoutManager= LinearLayoutManager(context)
            howerlyAdapter= HourlyAdapter(context)
            howerlyRecycler.adapter=howerlyAdapter
            dateFormat(attributeSet)
            assignClickHandlers()
        }

    }
    private fun dateFormat(attributeSet: AttributeSet?){
        val tArray=context.obtainStyledAttributes(attributeSet, R.styleable.SrCalenderView)
        try{
            dateFormat=tArray.getString(R.styleable.SrCalenderView_dateFormat)
            if (dateFormat==null){
                dateFormat=DATE_FORMAT
            }
        }finally {
            tArray.recycle()
        }
    }
    private fun assignClickHandlers(){
        binding.apply {
            nextBtn.setOnClickListener {
                currentDate.add(Calendar.MONTH,1)
                updateCalander()
            }
            previousBtn.setOnClickListener {
                currentDate.add(Calendar.MONTH,-1)
                updateCalander()
            }
            nextSchBtn.setOnClickListener {
                currentDate.add(Calendar.DAY_OF_MONTH,1)
                updateCalander()
            }
            previousSchBtn.setOnClickListener {
                currentDate.add(Calendar.DAY_OF_MONTH,-1)
                updateCalander()
            }
            calenderBtn.setOnClickListener {
                hourlyLayout.visibility= View.GONE
                monthlyLayout.visibility= View.VISIBLE
            }
            eventsBtn.setOnClickListener {
                hourlyLayout.visibility= View.VISIBLE
                monthlyLayout.visibility= View.GONE
            }

        }
    }
    fun updateCalander(){
        val events=HashSet<Date>()
        events.add(Date())
        updateCalender(events)
    }
    fun updateCalender(events:HashSet<Date>?){
        val cells=ArrayList<CalenderData>()
        val events=ArrayList<EventsData>()

        val calander=currentDate.clone() as Calendar
        calander.set(Calendar.DAY_OF_MONTH,1)
        val monthBegineeningSell=calander.get(Calendar.DAY_OF_WEEK)-1
        calander.add(Calendar.DAY_OF_MONTH,-monthBegineeningSell)
        while (cells.size<DAYS_COUNT){
            events.clear()
            //events.add(EventsData("SEvent",calander.time,"1:28pm"))
            cells.add(CalenderData(calander.time,events,false,true))
            calander.add(Calendar.DAY_OF_MONTH,1)
        }
        binding.apply {
            calanderAdapter.updateSrcalanderAdapter(cells)
            val sdf= SimpleDateFormat(dateFormat)
            currentDateTxt.text=sdf.format(currentDate.time)
            monthYearTimelyTxt.text=sdf.format(currentDate.time)
            val sdf_date= SimpleDateFormat("dd MMM yyyy")
            dateTimelyTxt.text=sdf_date.format(currentDate.time)
            //Howerly
            updateHowerly(durationGlobal)
        }
    }
    fun updateDuration(duration:Int){
        durationGlobal=duration
    }
    private fun updateHowerly(duration:Int){
        val timeList=ArrayList<HourlyData>()
        val subTimeSlots=ArrayList<SubTimeData>()
        val subTimeSize=60/duration

        for (i in 0..23){
            subTimeSlots.clear()
            var subDurationIncre=0
            val time=if (i.toString().length>1) {
                "${i+1}:00"
            }else{
                "0${i+1}:00"
            }
            var sub: SubTimeData?=null
            for (s in 0 until subTimeSize){
                subDurationIncre += duration
                sub= SubTimeData("$time:${subDurationIncre}","")
                subTimeSlots.add(sub)
            }

            timeList.add(HourlyData(time,subTimeSlots))

        }
        howerlyAdapter.updateHourlyAdapter(timeList)
    }
    fun setEventHandler(eventHandler: EventHandler){
        this.eventHandle=eventHandler
    }
}












