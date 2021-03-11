package com.drping.zotcartest.main

import android.content.Context
import com.drping.zotcartest.entity.Car

class MainActivityContract {
    interface View {
        fun getAppContext(): Context
        fun setCars(list: List<Car>)
    }

    interface Presenter {
        fun getListCars()
    }
}