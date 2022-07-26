package com.example.webviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private val URL = "https://myknowledgechat.rbspeople.com"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webView = WebView(applicationContext)
        webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            isScrollbarFadingEnabled = true
            setInitialScale(150)
            loadUrl(URL)

        }
        setContentView(webView)

    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}