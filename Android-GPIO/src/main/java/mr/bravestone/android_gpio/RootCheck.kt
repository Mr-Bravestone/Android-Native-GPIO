package mr.bravestone.android_gpio

class RootCheck {
    fun Ability(): Int {
        try{
            var result = ShellExec("su -c ls").Status
            if(result == "pass")
            {
                println("Rooted")
                return 1
            }
            else
            {
                println("RootNotFound")
                return 0
            }

        }catch(e: Exception){
            println("RootNotFound")
            return 0
        }

    }
}