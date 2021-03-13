package com.drping.zotcartest.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.drping.zotcartest.R
import com.drping.zotcartest.entity.Car

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [carDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarDetail : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        car = arguments?.getSerializable("car") as Car
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_car_detail, container, false)
        rootView.findViewById<TextView>(R.id.name_car).text = "Mon Vehicule"
        rootView.findViewById<TextView>(R.id.model).text = car.model
        rootView.findViewById<TextView>(R.id.registration).text = car.registration
        rootView.findViewById<TextView>(R.id.oil).text = car.oil
        rootView.findViewById<TextView>(R.id.seat).text = car.seat
        rootView.findViewById<TextView>(R.id.doors).text = car.door
        rootView.findViewById<TextView>(R.id.price_car).text =
            (1000..100000).random().toString() + "€"
        rootView.findViewById<TextView>(R.id.desc).text = car.desc
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment carDetail.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CarDetail().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}