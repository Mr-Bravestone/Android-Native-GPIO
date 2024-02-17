package com.example.android_native_gpio

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import mr.bravestone.android_gpio.GPIO
import mr.bravestone.android_gpio.PCF8574
import mr.bravestone.android_gpio.RootCheck

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val chkRootBtn = findViewById<Button>(R.id.chkRoot)
        val pcfBtn = findViewById<Button>(R.id.pcfBtn)
        val obgpioBtn = findViewById<Button>(R.id.obgpio)
        chkRootBtn.setOnClickListener {
            println(RootCheck().Ability())
            if (RootCheck().Ability() == 1)
            {
                chkRootBtn.visibility = View.INVISIBLE
                pcfBtn.visibility = View.VISIBLE
                obgpioBtn.visibility = View.VISIBLE
                Toast.makeText(this,"Device is Rooted",Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this,"Device Not Rooted",Toast.LENGTH_SHORT).show()
            }
        }
        pcfBtn.setOnClickListener {


        }


    }
}