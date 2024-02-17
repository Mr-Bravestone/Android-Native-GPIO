package mr.bravestone.android_gpio

class PCF8574 {
    private var DeviceName = ""
    private var GPIOs = ""
    private var BusInfo = ""
    private var ChipName = ""
    private var DeviceStatus = ""
    private fun CheckDevice() {
        var result=ShellExec("su -c cat /sys/kernel/debug/gpio | grep pcf857").Result
        var resultSplitWith :List<String> = result.split(":",",").map { it.trim() }
        if (result.isBlank())
        {
            DeviceStatus = "NoDevice"
        }
        else if (result.isNotBlank()){
            DeviceStatus = "DeviceAvailable"
        }

        resultSplitWith.forEach {
            if (it.contains("gpiochip"))
            {
                var chipData: String = it.toString()
                ChipName = chipData.trim()
            }
            else if (it.contains("GPIOs"))
            {
                var gpioData: String = it.toString()
                GPIOs = gpioData.replace("GPIOs","").trim()
            }
            else if (it.contains("i2c"))
            {
                var businfoData: String = it.toString()
                BusInfo = businfoData.replace("i2c/","").trim()

            }
            else if (it.contains("pcf857"))
            {
                var deviceData: String = it.toString()
                DeviceName = deviceData.trim()
            }

        }
    }
    fun getChipName(): String {
        CheckDevice()
        if (DeviceStatus == "NoDevice"){
        return DeviceStatus
        }
        return ChipName
    }
    fun getGPIOs(): String {
        CheckDevice()
        if (DeviceStatus == "NoDevice"){
            return DeviceStatus
        }
        return GPIOs
    }    fun getBusInfo(): String {
        CheckDevice()
        if (DeviceStatus == "NoDevice"){
            return DeviceStatus
        }
        return BusInfo
    }
    fun getDeviceName(): String {
        CheckDevice()
        if (DeviceStatus == "NoDevice"){
            return DeviceStatus
        }
        return DeviceName
    }
    fun getDeviceStatus(): String {
        CheckDevice()
        if (DeviceStatus == "NoDevice"){
            return DeviceStatus
        }
        return DeviceStatus

    }

}