package com.example.accuratehome

import retrofit2.http.Body

data class RequestData(@Body
    val LotArea: List<Int>,
    val YearBuilt: List<Int>,
    val FstFlrSF: List<Int>,
    val SndFlrSF: List<Int>,
    val FullBath: List<Int>,
    val BedroomAbvGr: List<Int>,
    val TotRmsAbvGrd: List<Int>
)