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
        //println(PCF8574().getChipName())
        //println(PCF8574().getGPIOs())
        //println(PCF8574().getBusInfo())
        //println(PCF8574().getDeviceName())
        //println(PCF8574().Export(3))
        //println(PCF8574().Direction(3,"OUTPUT"))

//        while (true){
//            println(PCF8574().Write(3,"LOW"))
//            Thread.sleep(1000)
//            println(PCF8574().Write(3,"HIGH"))
//            Thread.sleep(1000)
//        }
        //println(PCF8574().Read(3))
        //println(PCF8574().UnExport(1))
        var Module = PCF8574()
        Module.pinMode(3,"OUTPUT")
        Module.pinMode(4,"OUTPUT")
        Module.digitalWrite(4,"HIGH")
        while (true)
        {
            Module.digitalWrite(3,"HIGH")
            Module.digitalWrite(4,"LOW")
            Thread.sleep(500)
            Module.digitalWrite(3,"LOW")
            Module.digitalWrite(4,"HIGH")
            Thread.sleep(500)

        }








    }
}