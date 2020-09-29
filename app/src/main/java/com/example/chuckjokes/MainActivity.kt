package com.example.chuckjokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.chuckjokes.fragments.JokeFragment
import com.example.chuckjokes.fragments.WebFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    companion object {
        const val SCREEN = "screen"
        var currentScreen: Int? = null
    }

    private lateinit var bottomNav: BottomNavigationView
    private var jokeFragment: Fragment? = null
    private var webFragment: Fragment? = null
    private lateinit var fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        fm = supportFragmentManager

        bottomNav = findViewById(R.id.bottom_nav)

        if (savedInstanceState != null) {
            setScreen(savedInstanceState.getInt(SCREEN))
        } else {
            setScreen(R.id.btn_joke)
        }

        bottomNav.setOnNavigationItemSelectedListener {
            setScreen(it.itemId)
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun setScreen(id: Int) {
        when (id) {
            R.id.btn_joke -> {
                jokeFragment = fm.findFragmentById(R.id.joke)
                if (jokeFragment == null) {
                    jokeFragment =
                        JokeFragment()
                    fm.beginTransaction().replace(R.id.fragment_container, jokeFragment as JokeFragment).commit()
                }
                currentScreen = R.id.btn_joke
            }
            R.id.btn_web -> {
                webFragment = fm.findFragmentById(R.id.web)
                if (webFragment == null) {
                    webFragment =
                        WebFragment()
                    fm.beginTransaction().replace(R.id.fragment_container, webFragment as WebFragment).commit()
                }
                currentScreen = R.id.btn_web
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        if (currentScreen != null) {
            outState.putInt(SCREEN, currentScreen!!)
        }
        super.onSaveInstanceState(outState, outPersistentState)
    }
}