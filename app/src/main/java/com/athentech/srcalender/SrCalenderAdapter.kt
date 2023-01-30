package com.athentech.srcalender

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.athentech.srcalender.databinding.SrCalanderAdapterItemBinding
import java.util.Calendar
import java.util.Date

class SrCalenderAdapter(var context: Context):RecyclerView.Adapter<SrCalenderAdapter.SrViewHolder>() {
    var list= mutableListOf<CalenderData>()
    fun updateSrcalanderAdapter(list: MutableList<CalenderData>){
        this.list=list.toMutableList()
        notifyDataSetChanged()
    }
    class SrViewHolder (var binding:SrCalanderAdapterItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SrViewHolder {
        val binding=SrCalanderAdapterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SrViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SrViewHolder, position: Int) {
        holder.binding.apply {
            val mainL=list[position]
            val dateL=mainL.dateList
            val calandar=Calendar.getInstance()
            calandar.time=dateL!!
            val dayOfMonth=calandar.get(Calendar.DAY_OF_MONTH)
            val month=calandar.get(Calendar.MONTH)
            val weekDay=calandar.get(Calendar.YEAR)
            val today=Date()
            val todayCalendar=Calendar.getInstance()
            todayCalendar.time=today
            dateTxt.text=dayOfMonth.toString()
            eventsRecycler.layoutManager=LinearLayoutManager(context)
            val eventAdapter=EventsAdapter()
            eventsRecycler.adapter=eventAdapter
            eventAdapter.updateEventsAdapter(mainL.eventsList!!)

           /* if (cal.eventsList!!.size>0){
                eventsRecycler.visibility=View.VISIBLE
            }else{
                eventsRecycler.visibility=View.GONE
            }*/
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}



















