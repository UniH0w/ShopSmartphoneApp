package com.example.data.storage

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.56.1:8081")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ShopApi::class.java)

}