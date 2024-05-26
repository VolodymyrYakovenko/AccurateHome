package com.example.accuratehome

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/getPredictionOutput")
    fun sendData(@Body requestBody: RequestBody): Call<Data>
}

data class RequestBody(
    @SerializedName("LotArea") val lotArea: List<Int>, //4
    @SerializedName("YearBuilt") val yearBuilt: List<Int>, //7
    @SerializedName("1stFlrSF") val firstFloorSF: List<Int>, //2
    @SerializedName("2ndFlrSF") val secondFloorSF: List<Int>, //5
    @SerializedName("FullBath") val fullBath: List<Int>, //3
    @SerializedName("BedroomAbvGr") val bedroomAbvGr: List<Int>, //1
    @SerializedName("TotRmsAbvGrd") val totRmsAbvGrd: List<Int> //6
)