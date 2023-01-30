package com.athentech.calendarview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.athentech.calendarview.data.EventsData
import com.athentech.calendarview.databinding.EventsAdapterItemBinding

class EventsAdapter : RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {
    var list= mutableListOf<EventsData>()
    fun updateEventsAdapter(list: List<EventsData>){
        this.list=list.toMutableList()
        notifyDataSetChanged()
    }
    class EventViewHolder (var binding: EventsAdapterItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding=EventsAdapterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.binding.apply {
            val l=list[position]
            //eventsTxt.text="${l.time} ${l.eventTitle}"
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}