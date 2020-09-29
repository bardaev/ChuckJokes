package com.example.chuckjokes.fragments

import com.example.chuckjokes.rest.model.JokeItem
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface JokeView : MvpView{
    fun showJokes(listJoke: List<JokeItem>)
    fun showError()
}