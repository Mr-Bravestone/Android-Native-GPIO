package com.example.android_native_gpio

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import mr.bravestone.android_gpio.PCF8575
import mr.bravestone.android_gpio.RootCheck

class MainActivity : AppCompatActivity() {


    val gpioPinNums: IntArray = intArrayOf(1264, 1265, 1266, 1267, 1268, 1269, 1270, 1271, 1272, 1273, 1274, 1275, 1276, 1277, 1278, 1279)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (RootCheck().Ability())
                {
                    Toast.makeText(applicationContext,"Rooted",Toast.LENGTH_SHORT).show()
                    if(PCF8575().getDeviceStatus().equals("DeviceAvailable")){
                        startActivity(Intent(this@MainActivity,PinList::class.java))
                    }
                    else
                    {
                        Toast.makeText(applicationContext,"No Gpio Expander Detected",Toast.LENGTH_SHORT).show()
                    }


                }
                else
                {
                    Toast.makeText(applicationContext,"Root Access Not Available",Toast.LENGTH_SHORT).show()
                }
            }
        })


    }


}