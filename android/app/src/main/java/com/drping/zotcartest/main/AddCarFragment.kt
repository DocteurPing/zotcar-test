package com.drping.zotcartest.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.drping.zotcartest.R
import com.drping.zotcartest.tools.VolleyRequest

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddCarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddCarFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_add_car, container, false)
        val button = rootView.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            sendCar(rootView)
        }
        return rootView
    }

    private fun sendCar(view: View) {
        context?.let { VolleyRequest.init(it) }
        val url = "http://192.168.1.23:5000/images"
        val volleyRequest = VolleyRequest(url, ::success) {}
        val header = HashMap<String, String>()
        val params = HashMap<String, String>()
        val body = "model=${
            view.findViewById<EditText>(R.id.model).text
        }&registration=${
            view.findViewById<EditText>(R.id.registration).text
        }&oil=${
            view.findViewById<EditText>(R.id.oil).text
        }&seat=${
            view.findViewById<EditText>(R.id.seat).text
        }&door=${
            view.findViewById<EditText>(R.id.doors).text
        }&desc=${
            view.findViewById<EditText>(R.id.desc).text
        }&image=test"
        volleyRequest.makeRequestToJSON(Request.Method.POST, header, params, body)
    }

    private fun success(json: String) {
        Toast.makeText(context, "La voiture a bien été ajouté", Toast.LENGTH_SHORT).show()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddCarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddCarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}