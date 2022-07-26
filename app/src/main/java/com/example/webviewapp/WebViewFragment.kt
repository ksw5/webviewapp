package com.example.webviewapp

import android.graphics.Bitmap
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.webviewapp.databinding.FragmentWebViewBinding
import com.good.gd.GDStateListener


class WebViewFragment : Fragment(), GDStateListener {

    private var _binding: FragmentWebViewBinding? = null
    private val binding get() = _binding
    private val URL = BuildConfig.HostUrl


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpWebView()
    }

    private fun setUpWebView() {

        binding?.webView?.apply {
            webViewClient = MyWebViewClient()
            settings.javaScriptEnabled = true
            settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
            settings.domStorageEnabled = true
            settings.useWideViewPort = true
            isScrollbarFadingEnabled = true
            setInitialScale(150)
            loadUrl(URL)
        }
        binding?.webView?.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && binding?.webView?.canGoBack() == true) {
                binding?.webView?.goBack() // Navigate back to previous web page if there is one
                //nested_scroll.scrollTo(0, 0) // Scroll webview back to top of previous page
            }
            true
        }
    }

    private fun showProgress() {
        binding?.progressBar?.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        binding?.progressBar?.visibility = View.GONE
    }

    inner class MyWebViewClient : WebViewClient() {

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            showProgress()
            super.onPageStarted(view, url, favicon)
        }

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }

        override fun onPageFinished(view: WebView, url: String) {
            hideProgress()
            super.onPageFinished(view, url)

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAuthorized() {
        setUpWebView()
    }

    override fun onLocked() {
        TODO("Not yet implemented")
    }

    override fun onWiped() {
        TODO("Not yet implemented")
    }

    override fun onUpdateConfig(p0: MutableMap<String, Any>?) {
        TODO("Not yet implemented")
    }

    override fun onUpdatePolicy(p0: MutableMap<String, Any>?) {
        TODO("Not yet implemented")
    }

    override fun onUpdateServices() {
        TODO("Not yet implemented")
    }

    override fun onUpdateEntitlements() {
        TODO("Not yet implemented")
    }

}