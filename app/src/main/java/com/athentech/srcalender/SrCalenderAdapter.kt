package com.athentech.srcalender

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.athentech.srcalender.databinding.SrCalanderAdapterItemBinding

class SrCalenderAdapter:RecyclerView.Adapter<SrCalenderAdapter.SrViewHolder>() {
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
            val cal=list[position]



            if (cal.eventsList!!.size>0){
                eventsRecycler.visibility=View.VISIBLE
            }else{
                eventsRecycler.visibility=View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}