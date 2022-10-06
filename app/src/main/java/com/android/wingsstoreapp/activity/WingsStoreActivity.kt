package com.android.wingsstoreapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.wingsstoreapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WingsStoreActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.root_layout)
    }
}