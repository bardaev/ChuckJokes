package com.example.chuckjokes.rest

import com.example.chuckjokes.rest.model.JokeModel
import io.reactivex.Observable
import retrofit2.http.GET

interface JokeApi {

    @GET("/jokes")
    fun getJokes(): Observable<JokeModel>
}