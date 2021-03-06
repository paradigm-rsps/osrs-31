package osrs.classic.server

import com.uchuhimo.konf.Config
import com.uchuhimo.konf.toValue
import osrs.classic.server.util.logger.Logger
import java.io.File
import kotlin.system.exitProcess

object XteaConfig {

    private var config = Config()
    private val file = File("data/xteas/xteas.json")

    val xteas = mutableMapOf<Int, IntArray>()

    fun load() {
        if(!file.exists()) {
            Logger.error("Could not find region XTEA keys config file at 'data/xteas/xteas.json'. Make sure you have run the 'setup server' task.")
            exitProcess(0)
        }

        val entries = config.from.json.file(file).toValue<Array<XteaEntry>>()
        entries.forEach { xteas[it.mapsquare] = it.key }
    }

    operator fun get(regionId: Int): IntArray {
        return xteas[regionId] ?: IntArray(4) { 0 }
    }

    data class XteaEntry(val archive: Int, val group: Int, val nameHash: Int, val name: String, val mapsquare: Int, val key: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as XteaEntry

            if (archive != other.archive) return false
            if (group != other.group) return false
            if (nameHash != other.nameHash) return false
            if (name != other.name) return false
            if (mapsquare != other.mapsquare) return false
            if (!key.contentEquals(other.key)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = archive
            result = 31 * result + group
            result = 31 * result + nameHash
            result = 31 * result + name.hashCode()
            result = 31 * result + mapsquare
            result = 31 * result + key.contentHashCode()
            return result
        }

    }

    fun regionKeys(regionId: Int): IntArray = this[regionId]
}