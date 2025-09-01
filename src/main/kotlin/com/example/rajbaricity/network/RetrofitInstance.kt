package com.example.rajbaricity.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    // IMPORTANT: Replace with your actual backend server IP address or domain.
    // 10.0.2.2 is a special alias to your host loopback interface from the Android emulator.
    // If running on a physical device, use your computer's network IP.
    private const val BASE_URL = "http://10.0.2.2:8080/"

    val api: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}
