package com.kamus.m4_ejercicios.ejercicio2.graphic_components.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kamus.m4_ejercicios.R

class RVAdapter(private var list: List<Data>) : RecyclerView.Adapter<DataViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.render(list[position])
    }


}

class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val usrName = view.findViewById<TextView>(R.id.usrName)
    val usrLastName = view.findViewById<TextView>(R.id.usrLastName)
    val usrAge = view.findViewById<TextView>(R.id.usrAge)

    fun render(data: Data){
        usrName.text = data.name
        usrLastName.text = data.lastname
        usrAge.text = data.age.toString()
    }
}