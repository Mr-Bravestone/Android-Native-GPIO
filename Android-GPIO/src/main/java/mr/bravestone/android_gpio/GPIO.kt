package mr.bravestone.android_gpio

class GPIO {
    private fun Export(pin: Int): String {
        IO().Export(pin)
        return "OK"
    }
    private fun Direction(pin: Int,direction: String): String {
        var PinDirection: String
        when (direction) {
            "INPUT" -> PinDirection = "in"
            "OUTPUT" -> PinDirection = "out"
            else -> {
                return "Wrong_Direction"
            }
        }
        IO().Direction(pin,PinDirection)
        return "OK"
    }
    private fun Write(pin: Int,pulse: String): String {
        var Pulse: Int
        when (pulse) {
            "HIGH" -> Pulse = 1
            "LOW" -> Pulse = 0
            else -> {
                return "Wrong_Value"
            }
        }
        IO().Write(pin,Pulse)
        return "OK"
    }
    private fun Read(pin:Int): String {
        return IO().Read(pin)
    }
    private fun UnExport(pin:Int): String {
        IO().UnExport(pin)
        return "OK"

    }
    fun pinMode(pin: Int,direction: String): String {
        Export(pin)
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