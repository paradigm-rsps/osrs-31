package osrs.classic

import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JPanel

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AppletConfiguration.init()
            val frame = JFrame("OSRS Classic")
            frame.size = Dimension(1280, 720)
            val panel = JPanel()
            panel.size = frame.size
            frame.add(panel)
            panel.layout = BorderLayout()
            Applet.init()
            panel.add(Applet.applet, BorderLayout.CENTER)
            frame.show()
            Applet.applet.init()
            Applet.applet.start()
        }
    }
}