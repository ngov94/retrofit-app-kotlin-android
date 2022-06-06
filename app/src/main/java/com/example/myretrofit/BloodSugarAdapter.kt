package com.example.myretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class BloodSugarAdapter(private val bloodSugarList: List<BloodSugar>) : RecyclerView.Adapter<ViewHolder>() {
    //inflate a view and return it
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bloodSugarItemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.blood_sugar_list_item_layout, parent, false)
        return ViewHolder(bloodSugarItemView)
    }

    //add element to view holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = bloodSugarList[position]

        holder.sugarconcTextView.text = item.sugar_conc
        holder.sugarunitTextView.text = item.sugar_unit
        holder.dateIDTextView.text = item.date
        holder.timeTextView.text = item.time
        holder.measuredTextView.text = item.measured
        holder.notesTextView.text = item.notes


    }


    //size of the list/ data source
    override fun getItemCount(): Int {
        return bloodSugarList.size
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var sugarconcTextView: TextView = view.findViewById(R.id.sugar_conc)
    var sugarunitTextView: TextView = view.findViewById(R.id.sugar_unit)
    var dateIDTextView: TextView = view.findViewById(R.id.date)
    var timeTextView: TextView = view.findViewById(R.id.time)
    var measuredTextView: TextView = view.findViewById(R.id.measured)
    var notesTextView: TextView = view.findViewById(R.id.notes)

}
