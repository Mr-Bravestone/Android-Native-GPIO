package com.example.android_native_gpio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import mr.bravestone.android_gpio.GPIO
import mr.bravestone.android_gpio.PCF8574
import mr.bravestone.android_gpio.RootCheck
import mr.bravestone.android_gpio.ShellExec

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //println(RootCheck().Ability())
        //println(GPIO().Export(43))
        //println(GPIO().Read(43))
        //println(GPIO().Direction(43,"out"))
        //println(GPIO().Write(43,0))
        println(PCF8574().getChipName())
        println(PCF8574().getGPIOs())
        println(PCF8574().getBusInfo())
        println(PCF8574().getDeviceName())




    }
}