package com.example.chuckjokes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.chuckjokes.R

class WebFragment: Fragment() {

    companion object {
        const val URL = "http://icndb.com/api/"
    }

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.web_layout, container, false)
        webView = v.findViewById(R.id.web)
        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState)
        } else {
            webView.webViewClient = ClientWebView()
            webView.settings.javaScriptEnabled = true
            webView.loadUrl(URL)
        }
        return v
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState)
    }
}