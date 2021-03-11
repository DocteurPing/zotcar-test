package com.drping.zotcartest.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drping.zotcartest.entity.Car

class ListCarAdapter(
    private val list: List<Car>,
) : RecyclerView.Adapter<ListCarHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCarHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ListCarHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ListCarHolder, position: Int) {
        val entite: Car = list[position]
        holder.itemView.setOnClickListener {
            //view.navigateToRestaurant(list[position])
        }
        holder.bind(entite)
    }

}