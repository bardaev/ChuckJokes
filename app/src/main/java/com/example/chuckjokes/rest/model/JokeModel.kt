package com.example.chuckjokes.rest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class JokeModel {

    @SerializedName("value")
    @Expose
    var value: List<JokeItem>? = null
}