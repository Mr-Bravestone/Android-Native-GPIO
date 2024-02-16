package mr.bravestone.android_gpio

class GPIO {


    //echo 1 >  /sys/class/gpio/gpio176/value
    fun Export(pin:Int)
    {
        ShellExec("su -c echo $pin  > /sys/class/gpio/export")
    }
    fun Direction(pin:Int,direction: String)
    {
        ShellExec("su -c echo $direction > /sys/class/gpio/gpio$pin/direction")
    }
    fun Write(pin:Int,pulse: Int)
    {
        ShellExec("su -c echo $pulse >  /sys/class/gpio/gpio$pin/value")
    }
    fun Read(pin: Int): String {
        return ShellExec("su -c cat /sys/class/gpio/gpio$pin/value").Result
    }
    fun UnExport(pin:Int)
    {
        ShellExec("su -c echo $pin  > /sys/class/gpio/unexport")
    }
}