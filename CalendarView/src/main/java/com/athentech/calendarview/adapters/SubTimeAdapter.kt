package com.athentech.calendarview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.athentech.calendarview.data.SubTimeData
import com.athentech.calendarview.databinding.SubTimeAdapterItemBinding

class SubTimeAdapter : RecyclerView.Adapter<SubTimeAdapter.ViewHolder>() {
    var list= mutableListOf<SubTimeData>()
    fun updateSubTimeAdapter(list: List<SubTimeData>){
        this.list=list.toMutableList()
        notifyDataSetChanged()
    }
    class ViewHolder (var binding: SubTimeAdapterItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=SubTimeAdapterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val l=list[position]
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}