package com.android.wingsstoreapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.wingsstoreapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_layout)

        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            startActivity(Intent(this@SplashScreen, WingsStoreActivity::class.java))
            finish()
        }
    }
}