package com.example.fusha.translate

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val service: LibreApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://libretranslate.com/") // public instance
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LibreApi::class.java)
    }
}