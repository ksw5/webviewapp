package com.example.webviewapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.good.gd.GDAndroid
import com.good.gd.GDStateListener

class MainActivity : AppCompatActivity(), GDStateListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container_view, WebViewFragment()).commit()

        GDAndroid.getInstance().activityInit(this@MainActivity)

    }

    override fun onAuthorized() {

    }

    override fun onLocked() {

    }

    override fun onWiped() {

    }

    override fun onUpdateConfig(p0: MutableMap<String, Any>?) {

    }

    override fun onUpdatePolicy(p0: MutableMap<String, Any>?) {

    }

    override fun onUpdateServices() {

    }

    override fun onUpdateEntitlements() {

    }
}