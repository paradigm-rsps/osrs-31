package osrs.classic.server.util.logger

import java.lang.Exception
import java.lang.StringBuilder
import java.util.*

object Logger {
    var plugin: String? = null
    var format = "%-20s%s%n"
    var header = ""
    fun info(message: Any, vararg replacers: Any) {
        printColorMessageReplacers(ANSI_WHITE, message, *replacers)
    }

    fun warn(message: Any, vararg replacers: Any) {
        printColorMessageReplacers(ANSI_YELLOW, message, *replacers)
    }

    fun warn(message: String, e: Exception) {
        printColorMessage(ANSI_RED, message)
        e.printStackTrace()
    }

    fun debug(message: Any, vararg replacers: Any) {
        if (!isDebugEnabled) {
            return
        }
        printColorMessageReplacers(ANSI_GREEN, message, *replacers)
    }

    fun error(message: Any, vararg replacers: Any) {
        printColorMessageReplacers(ANSI_RED, message, *replacers)
    }

    private fun printColorMessage(ansiColor: String, message: Any) {
        val tempName: String = if (plugin != null) {
            plugin.toString()
        } else {
            header
        }
        var headerColor = DEFAULT_CONTROLLER_COLOR
        if (header == "Client") {
            headerColor = ANSI_PURPLE
        } else if (header == "Server") {
            headerColor = ANSI_BLUE
        }
        val header = Message.newMessage()
            .add(headerColor, "[$tempName] ")
            .build()

        System.out.format(format, header, ansiColor + message)
        print(ANSI_RESET)
    }

    private fun printColorMessageReplacers(ansiColor: String, message: Any, vararg replacers: Any) {
        val sRef: String = try {
            message as String
        } catch (e: Exception) {
            printColorMessage(ansiColor, message)
            return
        }
        if (!sRef.contains("{}")) {
            printColorMessage(ansiColor, sRef)
            return
        }
        val finalMessage = StringBuilder()
        val replacersArray = Arrays.stream(replacers).toArray()
        for ((i, s) in sRef.split("{}").toTypedArray().withIndex()) {
            if (i != replacersArray.size) finalMessage.append(s).append(replacersArray[i]) else finalMessage.append(s)
        }
        printColorMessage(ansiColor, finalMessage)
    }

    const val ANSI_RESET = "\u001B[0m"
    const val ANSI_BLACK = "\u001B[30m"
    const val ANSI_RED = "\u001B[31m"
    const val ANSI_GREEN = "\u001B[32m"
    const val ANSI_YELLOW = "\u001B[33m"
    const val ANSI_BLUE = "\u001B[34m"
    const val ANSI_PURPLE = "\u001B[35m"
    const val ANSI_CYAN = "\u001B[36m"
    const val ANSI_WHITE = "\u001B[37m"
    var DEFAULT_CONTROLLER_COLOR = ANSI_CYAN
    var isDebugEnabled = true
}