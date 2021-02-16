package com.rkr.enfecproject.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object {
        val sURL1 = "https://jsonplaceholder.typicode.com"
        val sURL2 = "https://jsonplaceholder.typicode.com"
        fun getRetroInstanceUsers(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(sURL1)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }

        fun getRetroInstancePost(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(sURL2)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}