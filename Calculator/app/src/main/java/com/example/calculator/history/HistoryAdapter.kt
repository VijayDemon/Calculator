package com.example.calculator.history
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.R

import com.example.calculator.database.EntityFile

class HistoryHolder(itemView :View) :RecyclerView.ViewHolder(itemView) {

    val col1: TextView = itemView.findViewById(R.id.c1)
    val col2: TextView = itemView.findViewById(R.id.c2)
    val col3: TextView = itemView.findViewById(R.id.c3)
    val col4: TextView = itemView.findViewById(R.id.c4)
    init {
        itemView.setOnClickListener { v: View ->
            val position: Int = adapterPosition
        }
    }
}


class HistoryAdapter(private val context: Context
                     ,private  val data : List<EntityFile> )
    : RecyclerView.Adapter<HistoryHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            HistoryHolder {
        val v =LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list,parent,false)

        return HistoryHolder(v)
     }

    override fun getItemCount(): Int {
        return data.size
    }


    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        holder.col1.text ="Question :"+data[position].OperationName
        holder.col2.text= "Answer :"+data[position].Result
        holder.col3.text="Start Time :"+data[position].Start_time
        holder.col4.text="Stop Time :"+data[position].End_time
    }
   }
