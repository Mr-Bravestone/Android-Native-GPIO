package mr.bravestone.android_gpio

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class ShellExec constructor(Command: String) {
    var Result = ""
    init {
        try {
            val process = Runtime.getRuntime().exec(Command)
            val reader = BufferedReader(
                InputStreamReader(process.inputStream)
            )
            var read: Int
            val buffer = CharArray(4096)
            val output = StringBuffer()
            while (reader.read(buffer).also { read = it } > 0) {
                output.append(buffer, 0, read)
            }
            reader.close()
            process.waitFor()
            Result=output.toString()
        } catch (e: IOException) {
            println("RuntimeException $Command Failed to Execute")
        } catch (e: InterruptedException) {
            println("IntruptedException $Command Execution Not Successful")
        }
    }

}