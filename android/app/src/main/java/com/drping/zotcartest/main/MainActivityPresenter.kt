package com.drping.zotcartest.main

import com.android.volley.Request
import com.drping.zotcartest.entity.Car
import com.drping.zotcartest.tools.VolleyRequest
import org.json.JSONArray
import org.json.JSONObject

class MainActivityPresenter(private val mainActivityView: MainActivityContract.View) :
    MainActivityContract.Presenter {
    override fun getListCars() {
        VolleyRequest.init(mainActivityView.getAppContext())
        val url = "https://192.168.1.23:5000/images"
        val volleyRequest = VolleyRequest(url, ::getCars) {}
        val header = HashMap<String, String>()
        val params = HashMap<String, String>()
        val body = ""
        volleyRequest.makeRequestToJSON(Request.Method.GET, header, params, body)
    }

    private fun getCars(json: String) {
        val list = ArrayList<Car>()
        val listRestaurant = JSONArray(JSONObject(json).getString("cars"))
        for (i in 0 until listRestaurant.length()) {
            val item = JSONObject(listRestaurant.getString(i))
            val car = Car(
                item.getString("brand"),
                item.getString("model"),
                item.getString("registration"),
                item.getString("oil"),
                item.getString("seat"),
                item.getString("door"),
                item.getString("desc"),
                item.getString("image")
            )
            list.add(car)
        }
        mainActivityView.setCars(list)
    }
}