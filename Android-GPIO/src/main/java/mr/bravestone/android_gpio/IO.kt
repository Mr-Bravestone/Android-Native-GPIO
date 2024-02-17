package mr.bravestone.android_gpio

class IO {
    fun Export(pin:Int): String {
        return ShellExec("su -c echo $pin  > /sys/class/gpio/export").Status
    }
    fun Direction(pin:Int,direction: String): String {
        return ShellExec("su -c echo $direction > /sys/class/gpio/gpio$pin/direction").Status
    }
    fun Write(pin:Int,pulse: Int): String {
        return ShellExec("su -c echo $pulse >  /sys/class/gpio/gpio$pin/value").Status
    }
    fun Read(pin: Int): String {
        return ShellExec("su -c cat /sys/class/gpio/gpio$pin/value").Result
    }
    fun UnExport(pin:Int): String {
        return ShellExec("su -c echo $pin  > /sys/class/gpio/unexport").Status
    }
}