package com.example.androidassignment.network

import com.example.androidassignment.model.OffersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers


internal interface APIService {
    @Headers("Content-Type: application/json")
    @GET("test/home")
    fun getOffers(): Call<OffersResponse>

}