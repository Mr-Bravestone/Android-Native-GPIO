package mr.bravestone.android_gpio

class RootCheck {
    fun Ability(): Int {
        try{
            println(ShellExec("su -c ls"))
            println("Rooted")
            return 1
        }catch(e: Exception){
            println("RootNotFound")
            return 0
        }

    }
}