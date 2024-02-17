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
        println(RootCheck().Ability())
        println(GPIO().Export(43))
        //println(GPIO().Read(43))
        //println(GPIO().Direction(43,"out"))
        //println(GPIO().Write(43,0))
        //println(PCF8574().CheckDevice())
        var result=ShellExec("su -c cat /sys/kernel/debug/gpio | grep pcf857").Result
        var resultString = result.toString()
        var resultSplitWith :List<String> = result.split(":",",").map { it.trim() }

        resultSplitWith.forEach {
            if (it.contains("gpiochip"))
            {
                println("Gpiochip - " + it)
            }
            else if (it.contains("GPIOs"))
            {
                println("GPIOs - " + it)

            }
            else if (it.contains("parent"))
            {
                println("Bus - " + it)
            }
            else if (it.contains("pcf857"))
            {
                println("Device - " + it)
            }


        }



    }
}