package com.example.accuratehome

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiViewModel : ViewModel() {
    val predictedPrice: MutableLiveData<Int> = MutableLiveData()

    fun sendApiRequest(lotArea: Int, yearBuilt: Int, firstFloorSF: Int, secondFloorSF: Int,
                       fullBath: Int, bedroomAbvGr: Int, totRmsAbvGrd: Int) {
        val requestdata = RequestBody(
            lotArea = listOf(lotArea),
            yearBuilt = listOf(yearBuilt),
            firstFloorSF = listOf(firstFloorSF),
            secondFloorSF = listOf(secondFloorSF),
            fullBath = listOf(fullBath),
            bedroomAbvGr = listOf(bedroomAbvGr),
            totRmsAbvGrd = listOf(totRmsAbvGrd)
            )
        RetrofitInstance.api.sendData(requestdata).enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                if (response.isSuccessful) {
                    val predictedPriceResponse = response.body()
                    predictedPrice.value = predictedPriceResponse?.predicted_price
                } else {
                    Log.d("API", "Request failed with code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d("API", "Request failed: ${t.message}")
            }
        })
    }
}