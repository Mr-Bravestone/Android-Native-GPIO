package mr.bravestone.android_gpio

import android.bluetooth.BluetoothClass.Device

class PCF8574 {
    var Device = ""
    var Gpios = ""
    var BusInfo = ""
    var ChipName = ""
    fun CheckDevice(): String {
        var result=ShellExec("su -c cat /sys/kernel/debug/gpio | grep pcf857").Result
        var resultString = result.toString()
        var resultSplitWith = listOf(result.split(",|:").map { it.trim() })

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
        return resultString

    }
}