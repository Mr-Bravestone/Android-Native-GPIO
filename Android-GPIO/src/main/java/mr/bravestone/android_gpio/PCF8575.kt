package mr.bravestone.android_gpio

class PCF8575 {
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
    private fun Export(pin: Int): String {
        var PinNum: Int
        when (pin) {
            1 -> PinNum = 1264
            2 -> PinNum = 1265
            3 -> PinNum = 1266
            4 -> PinNum = 1267
            5 -> PinNum = 1268
            6 -> PinNum = 1269
            7 -> PinNum = 1270
            8 -> PinNum = 1271
            9 -> PinNum = 1272
            10 -> PinNum = 1273
            11 -> PinNum = 1274
            12 -> PinNum = 1275
            13 -> PinNum = 1276
            14 -> PinNum = 1277
            15 -> PinNum = 1278
            16 -> PinNum = 1279
            else -> {
                return "Wrong_Pin_Number"
            }
        }
        IO().Export(PinNum)
        return "OK"

    }
    private fun Direction(pin: Int,direction: String): String {
        var PinNum: Int
        var PinDirection: String
        when (pin) {
            1 -> PinNum = 1264
            2 -> PinNum = 1265
            3 -> PinNum = 1266
            4 -> PinNum = 1267
            5 -> PinNum = 1268
            6 -> PinNum = 1269
            7 -> PinNum = 1270
            8 -> PinNum = 1271
            9 -> PinNum = 1272
            10 -> PinNum = 1273
            11 -> PinNum = 1274
            12 -> PinNum = 1275
            13 -> PinNum = 1276
            14 -> PinNum = 1277
            15 -> PinNum = 1278
            16 -> PinNum = 1279
            else -> {
                return "Wrong_Pin_Number"
            }
        }
        when (direction) {
            "INPUT" -> PinDirection = "in"
            "OUTPUT" -> PinDirection = "out"
            else -> {
                return "Wrong_Direction"
            }
        }
        IO().Direction(PinNum,PinDirection)
        return "OK"

    }
    private fun Write(pin: Int,pulse: String): String {
        var PinNum: Int
        var Pulse: Int
        when (pin) {
            1 -> PinNum = 1264
            2 -> PinNum = 1265
            3 -> PinNum = 1266
            4 -> PinNum = 1267
            5 -> PinNum = 1268
            6 -> PinNum = 1269
            7 -> PinNum = 1270
            8 -> PinNum = 1271
            9 -> PinNum = 1272
            10 -> PinNum = 1273
            11 -> PinNum = 1274
            12 -> PinNum = 1275
            13 -> PinNum = 1276
            14 -> PinNum = 1277
            15 -> PinNum = 1278
            16 -> PinNum = 1279
            else -> {
                return "Wrong_Pin_Number"
            }
        }
        when (pulse) {
            "HIGH" -> Pulse = 1
            "LOW" -> Pulse = 0
            else -> {
                return "Wrong_Value"
            }
        }
        IO().Write(PinNum,Pulse)
        return "OK"

    }
    private fun Read(pin:Int): String {
        var PinNum: Int
        when (pin) {
            1 -> PinNum = 1264
            2 -> PinNum = 1265
            3 -> PinNum = 1266
            4 -> PinNum = 1267
            5 -> PinNum = 1268
            6 -> PinNum = 1269
            7 -> PinNum = 1270
            8 -> PinNum = 1271
            9 -> PinNum = 1272
            10 -> PinNum = 1273
            11 -> PinNum = 1274
            12 -> PinNum = 1275
            13 -> PinNum = 1276
            14 -> PinNum = 1277
            15 -> PinNum = 1278
            16 -> PinNum = 1279
            else -> {
                return "Wrong_Pin_Number"
            }
        }
        return IO().Read(PinNum)

    }
    private fun UnExport(pin:Int): String {
        var PinNum: Int
        when (pin) {
            1 -> PinNum = 1264
            2 -> PinNum = 1265
            3 -> PinNum = 1266
            4 -> PinNum = 1267
            5 -> PinNum = 1268
            6 -> PinNum = 1269
            7 -> PinNum = 1270
            8 -> PinNum = 1271
            9 -> PinNum = 1272
            10 -> PinNum = 1273
            11 -> PinNum = 1274
            12 -> PinNum = 1275
            13 -> PinNum = 1276
            14 -> PinNum = 1277
            15 -> PinNum = 1278
            16 -> PinNum = 1279
            else -> {
                return "Wrong_Pin_Number"
            }
        }
        IO().UnExport(PinNum)
        return "OK"

    }
    fun startModule(): String {
        for (i in 1..16) {
            Export(i)
            Direction(i, "OUTPUT")
            Write(i, "LOW")
        }
        return "OK"
    }
    fun pinMode(pin: Int,direction: String): String {
        Direction(pin,direction)
        return "OK"
    }
    fun digitalWrite(pin: Int,pulse: String): String {
        Write(pin,pulse)
        return "OK"
    }
    fun digitalRead(pin: Int): String {
        return Read(pin)
    }


}