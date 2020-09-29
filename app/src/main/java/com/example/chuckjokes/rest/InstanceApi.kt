package com.example.chuckjokes.rest

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class InstanceApi {
    companion object {
        fun getApi(): JokeApi {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.icndb.com")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit.create(JokeApi::class.java)
        }
    }
}