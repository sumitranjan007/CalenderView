package com.athentech.calendarview.adapters

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.athentech.calendarview.R
import com.athentech.calendarview.data.CalenderData
import com.athentech.calendarview.databinding.CalanderAdapterItemBinding
import com.athentech.calendarview.util.getDayNameOfTheDay
import com.athentech.calendarview.util.isGreaterDate
import java.util.*

class CalenderAdapter (var context: Context,var listener:CalenderListner): RecyclerView.Adapter<CalenderAdapter.SrViewHolder>() {
    var list= mutableListOf<CalenderData>()
    fun updateSrcalanderAdapter(list: MutableList<CalenderData>){
        this.list=list.toMutableList()
        notifyDataSetChanged()
    }
    class SrViewHolder (var binding:CalanderAdapterItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SrViewHolder {
        val binding=
            CalanderAdapterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SrViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SrViewHolder, position: Int) {
        holder.binding.apply {
            val mainL=list[position]
            val dateL=mainL.dateList
            val calandar= Calendar.getInstance()
            calandar.time=dateL!!
            val dayOfMonth=calandar.get(Calendar.DAY_OF_MONTH)
            val month=calandar.get(Calendar.MONTH)
            val year=calandar.get(Calendar.YEAR)

            dateTxt.text=dayOfMonth.toString()
            eventsRecycler.layoutManager= LinearLayoutManager(context)
            val eventAdapter=EventsAdapter()
            eventsRecycler.adapter=eventAdapter
            eventAdapter.updateEventsAdapter(mainL.eventsList!!)
            //
            val today= Date()
            val todayCalendar= Calendar.getInstance()
            todayCalendar.time=today
             if (isGreaterDate(dateL,today) && dayOfMonth!=todayCalendar.get(Calendar.DAY_OF_MONTH)){
                 dateTxt.setTextColor(context.resources.getColor(R.color.greyed_out,null))
             }else if (dayOfMonth==todayCalendar.get(Calendar.DAY_OF_MONTH) && month==todayCalendar.get(Calendar.MONTH) && year==todayCalendar.get(Calendar.YEAR)){
                  dateTxt.setTypeface(null,Typeface.BOLD)
                 dateTxt.setTextColor(context.resources.getColor(R.color.white,null))
                 dateTxt.background=ResourcesCompat.getDrawable(context.resources,R.drawable.shape_selected_date,null)
             }else if (getDayNameOfTheDay(dateL)=="Sun"){
                 dateTxt.setTextColor(context.resources.getColor(R.color.greyed_out,null))
             }
             if (mainL.eventsList!!.size>0){
                 eventsRecycler.visibility=View.VISIBLE
             }else{
                 eventsRecycler.visibility= View.GONE
             }
            holder.itemView.setOnClickListener {

                listener.dateClicked(dateL)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    interface CalenderListner{
        fun dateClicked(date: Date)
    }

}














