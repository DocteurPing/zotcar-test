package com.drping.zotcartest.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drping.zotcartest.R
import com.drping.zotcartest.entity.Car

class ListCarHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.row_item_car, parent, false)) {

    private var name: TextView? = null
    private var image: ImageView? = null
    private var price: TextView? = null


    init {
        name = itemView.findViewById(R.id.name_car)
        image = itemView.findViewById(R.id.image_car)
        price = itemView.findViewById(R.id.price_car)
    }

    @SuppressLint("SetTextI18n")
    fun bind(car: Car) {
        name!!.text = car.brand + car.model
        price!!.text = (1000..100000).random().toString() + "€"
    }

}