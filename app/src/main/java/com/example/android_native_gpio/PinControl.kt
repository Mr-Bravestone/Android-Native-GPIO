package com.example.android_native_gpio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import mr.bravestone.android_gpio.IO

class PinControl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_control)

        var id = intent.extras?.getInt("id")
        var text = intent.extras?.getString("text")
        val Info = findViewById<TextView>(R.id.info)
        Info.text= text

        val radioGroup = findViewById<RadioGroup>(R.id.directionRadio)

        val outRadio = findViewById<RadioButton>(R.id.out)
        val inRadio = findViewById<RadioButton>(R.id.inp)
        val ValSwitch = findViewById<Switch>(R.id.ValSwitch)
        val ReadBtn = findViewById<Button>(R.id.ReadBtn)
        val ReadVal = findViewById<TextView>(R.id.ReadVal)

        if (IO().GetDirection(id!!).contains("out"))
        {
            ValSwitch.setEnabled(true)
            outRadio.setChecked(true)
            ReadBtn.setEnabled(false)
        }
        else if (IO().GetDirection(id!!).contains("in"))
        {
            inRadio.setChecked(true)
            ValSwitch.setEnabled(false)
            ReadBtn.setEnabled(true)
        }

        if (IO().GetValue(id!!).contains("1"))
        {
            ValSwitch.setChecked(true);
        }
        else if (IO().GetValue(id!!).contains("0"))
        {
            ValSwitch.setChecked(false)
        }

        ReadBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var result = IO().Read(id)
                ReadVal.text = result
            }
        })

        ValSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
            {
                IO().Write(id,0)
            }
            else
            {
                IO().Write(id,1)
            }
        }




        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            if (radioButton.text.equals("INPUT"))
            {
                IO().Direction(id!!.toInt(),"in")
                ValSwitch.setEnabled(false)
                ReadBtn.setEnabled(true)
            }
            else if(radioButton.text.equals("OUTPUT"))
            {
                IO().Direction(id!!.toInt(),"out")
                ValSwitch.setEnabled(true)
                ReadBtn.setEnabled(false)
            }
        }

    }

}