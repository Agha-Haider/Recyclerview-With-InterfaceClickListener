package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R

interface OnclickListener{

    fun OnItemClick(item:Data,position: Int)
}

class CustomAdapter (private val list: ArrayList<Data>,private val onclickListener: OnclickListener): RecyclerView.Adapter<CustomAdapter.viewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {

        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.list_item,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val list=list[position]
        holder.textView.text= list.name

        holder.constraintLayout.setOnClickListener{
            onclickListener.OnItemClick(list,position)
        }
    }

    class viewHolder(val view: View): RecyclerView.ViewHolder(view){

        val textView:TextView=view.findViewById(R.id.textView)
        val constraintLayout:ConstraintLayout=view.findViewById(R.id.clicked_layout)
    }
}