package com.drping.zotcartest.main

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.drping.zotcartest.R
import com.drping.zotcartest.entity.Car
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    private lateinit var presenter: MainActivityPresenter
    private lateinit var cars: List<Car>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainActivityPresenter(this)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)
        bottomNavigationView.setupWithNavController(navController)
        presenter.getListCars()
    }

    override fun getAppContext(): Context {
        return this
    }

    override fun setCars(list: List<Car>) {
        cars = list
        findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ListCarAdapter(cars)
        }
    }
}