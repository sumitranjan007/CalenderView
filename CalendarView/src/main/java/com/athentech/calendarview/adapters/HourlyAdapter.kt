package com.athentech.calendarview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.athentech.calendarview.data.HourlyData
import com.athentech.calendarview.databinding.HourlyAdapterItemBinding

class HourlyAdapter (var context: Context): RecyclerView.Adapter<HourlyAdapter.ViewHolder>() {
    var list= mutableListOf<HourlyData>()
    fun updateHourlyAdapter(list: List<HourlyData>){
        this.list=list.toMutableList()
        notifyDataSetChanged()
    }
    class ViewHolder(var binding: HourlyAdapterItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=HourlyAdapterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply{
            val t=list[position]
            mainTimeTxt.text=t.time
            subTimeSlotRecycler.layoutManager= LinearLayoutManager(context)
            val subAdapter=SubTimeAdapter()
            subTimeSlotRecycler.adapter=subAdapter
            subAdapter.updateSubTimeAdapter(t.subList!!)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}