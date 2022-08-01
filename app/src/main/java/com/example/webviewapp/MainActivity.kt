package com.example.webviewapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container_view, WebViewFragment()).commit()

    }

//    override fun onBackPressed() {
//        val count = supportFragmentManager.backStackEntryCount
//        if (count == 0) {
//            super.onBackPressed()
//            //add extra code
//        } else {
//            supportFragmentManager.popBackStack()
//        }
//    }

//    override fun onBackPressed() {
//        val webview: Fragment? = supportFragmentManager.findFragmentByTag("webviewfragment")
//        if (webview is WebViewFragment) {
//            val goback: Boolean = (webview as WebViewFragment?).canGoBack()
//            if (!goback) super.onBackPressed()
//        }
//    }

    //    override fun onBackPressed() {
//        if (webView.canGoBack()) {
//            webView.goBack()
//        } else {
//            super.onBackPressed()
//        }
//    }
}