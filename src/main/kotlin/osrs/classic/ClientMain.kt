package osrs.classic

import java.awt.BorderLayout
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants.EXIT_ON_CLOSE

class ClientMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AppletConfiguration.init()
            Applet.init()
            val frame = JFrame("OSRS Classic")
            frame.size = Applet.applet.size
            frame.isResizable = false
            val panel = JPanel()
            panel.size = frame.size
            frame.add(panel, null)
            panel.layout = BorderLayout()
            Applet.applet.size = frame.size
            panel.add(Applet.applet, BorderLayout.CENTER)
            frame.show()
            Applet.applet.init()
            Applet.applet.start()
            frame.defaultCloseOperation = EXIT_ON_CLOSE
        }
    }
}