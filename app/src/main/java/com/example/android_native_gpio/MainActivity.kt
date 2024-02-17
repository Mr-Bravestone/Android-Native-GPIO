package com.example.android_native_gpio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mr.bravestone.android_gpio.GPIO
import mr.bravestone.android_gpio.PCF8574

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}