package com.athentech.srcalender

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.athentech.srcalender.databinding.HourlyAdapterItemBinding

class HourlyAdapter:RecyclerView.Adapter<HourlyAdapter.ViewHolder>() {
    var list= mutableListOf<HourlyData>()
    fun updateHourlyAdapter(list: List<HourlyData>){
        this.list=list.toMutableList()
        notifyDataSetChanged()
    }
    class ViewHolder(var binding:HourlyAdapterItemBinding) :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=HourlyAdapterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply{
        val t=list[position]
            mainTimeTxt.text=t.time
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}