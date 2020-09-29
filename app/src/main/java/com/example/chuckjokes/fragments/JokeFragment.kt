package com.example.chuckjokes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chuckjokes.R
import com.example.chuckjokes.presenter.JokePresenter
import com.example.chuckjokes.rest.model.JokeItem
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class JokeFragment: MvpAppCompatFragment(), JokeView {


    @InjectPresenter
    lateinit var jokePresenter: JokePresenter

    private lateinit var btnReload: Button
    private lateinit var editText: EditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: JokeAdapter
    private lateinit var listJoke: List<JokeItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.joke_layout, container, false)
        btnReload = v.findViewById(R.id.button)
        editText = v.findViewById(R.id.count)
        recyclerView = v.findViewById(R.id.recycler)
        listJoke = ArrayList()
        adapter = JokeAdapter(listJoke)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        btnReload.setOnClickListener { loadJokes(it) }

        return v
    }

    override fun showJokes(listJoke: List<JokeItem>) {
        adapter.setList(listJoke)
    }

    override fun showError() {
        Toast.makeText(context, "Can't load jokes", Toast.LENGTH_SHORT)
    }

    fun loadJokes(view: View) {

        if (editText.text.toString().isNotEmpty()) {
            val count = java.lang.Long.valueOf(editText.text.toString())
            jokePresenter.loadJokes(count)
        } else {
            jokePresenter.loadJokes(Long.MAX_VALUE)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        jokePresenter.detachView(this)
    }
}