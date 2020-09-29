package com.example.chuckjokes.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chuckjokes.R
import com.example.chuckjokes.rest.model.JokeItem
import kotlinx.android.synthetic.main.item_joke.view.*

class JokeAdapter(private var jokes: List<JokeItem>): RecyclerView.Adapter<JokeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        return JokeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_joke, parent, false))
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(jokes[position].joke!!)
    }

    fun setList(newJokes: List<JokeItem>) {
        jokes = newJokes
        notifyDataSetChanged()
    }
}

class JokeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bind(text: String) {
        var t = text
        itemView.item_joke.text_joke.text = t
    }
}