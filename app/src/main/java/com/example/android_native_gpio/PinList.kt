package com.example.android_native_gpio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import mr.bravestone.android_gpio.IO
import mr.bravestone.android_gpio.PCF8575

class PinList : AppCompatActivity() {
    var Start: Int? = null
    var Stop: Int? = null
    var initval:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_list)

        GetGpioPinRange()
        for (i in Start!!..Stop!!)
        {
            addBtn(i)
            IO().Export(i)
        }
    }
    fun addBtn(i:Int){
        val layout = findViewById(R.id.layout) as LinearLayout
        val button = Button(this)
        button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        button.text = "PIN - "  + initval + "  ~~  GPIO " + " - " + i
        button.id = i
        button.setOnClickListener {
            var btnid = button.id
            var btntxt = button.text
            val intent = Intent(this, PinControl::class.java)
            intent.putExtra("id",btnid)
            intent.putExtra("text",btntxt)
            startActivity(intent)
            Toast.makeText(this, button.id.toString(), Toast.LENGTH_LONG).show()
        }
        layout.addView(button)
        initval++
    }
    fun GetGpioPinRange()
    {
        try {
            val gpio = PCF8575().getGPIOs()
            val splited=gpio.split("-")
            Start = splited[0].toIntOrNull()
            Stop = splited[1].toIntOrNull()
        }catch (e: Exception)
        {

        }

    }
}