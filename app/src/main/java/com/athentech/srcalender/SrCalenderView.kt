package com.athentech.srcalender

import android.content.Context
import android.provider.CalendarContract.Events
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.athentech.srcalender.databinding.CalenderMainViewBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class SrCalenderView constructor(context:Context?, attributeSet: AttributeSet?):LinearLayout(context,attributeSet) {
    private var dateFormat:String?=null
    private var DATE_FORMAT="MMM yyyy"
    private var currentDate=Calendar.getInstance()
    private var eventHandle:EventHandler?=null
    //How many Days to Show ,default to six weeks,42 days
    private val DAYS_COUNT = 42

    private lateinit var binding:CalenderMainViewBinding
    private lateinit var calanderAdapter:SrCalenderAdapter
    init {
      initUiControls(context,attributeSet)
    }
    constructor(context: Context?,attributeSet: AttributeSet?,defStyle:Int):this(context,attributeSet){
        initUiControls(context,attributeSet)
    }
    private fun initUiControls(context: Context?,attributeSet: AttributeSet?){
        binding= CalenderMainViewBinding.inflate(LayoutInflater.from(context),this,true)

        binding.apply {
            calenderRecycler.layoutManager=GridLayoutManager(context,7)
            calanderAdapter= SrCalenderAdapter(context!!)
            calenderRecycler.adapter=calanderAdapter
            dateFormat(attributeSet)
            assignClickHandlers()
        }

    }
    private fun dateFormat(attributeSet: AttributeSet?){
        val tArray=context.obtainStyledAttributes(attributeSet,R.styleable.SrCalenderView)
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
                currentDate.add(Calendar.MONTH,1)
                updateCalander()
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
            events.add(EventsData("SEvent",calander.time,"1:28pm"))
            cells.add(CalenderData(calander.time,events,false,true))
            calander.add(Calendar.DAY_OF_MONTH,1)
        }
        binding.apply {
            calanderAdapter.updateSrcalanderAdapter(cells)
            val sdf=SimpleDateFormat(dateFormat)
            currentDateTxt.text=sdf.format(currentDate.time)
            //Howerly

        }
    }
    fun setEventHandler(eventHandler: EventHandler){
        this.eventHandle=eventHandler
    }
}















































