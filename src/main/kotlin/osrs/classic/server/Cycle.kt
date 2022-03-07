package osrs.classic.server

import com.google.common.util.concurrent.ThreadFactoryBuilder
import kotlinx.coroutines.*
import osrs.classic.server.game.World
import osrs.classic.server.util.logger.Logger
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureNanoTime

@InternalCoroutinesApi
object Cycle {
    val tick: Int = 600
    private var excessCycleNanos = 0L

    val cycleExecutor = Executors.newSingleThreadScheduledExecutor(
        ThreadFactoryBuilder()
            .setDaemon(false)
            .setNameFormat("game")
            .setUncaughtExceptionHandler { t, e -> run{
                e.printStackTrace()
                Logger.error("An error occurred in the game thread $t.")
            }
            }
            .build()
    )

    private val cycle = CoroutineScope(cycleExecutor.asCoroutineDispatcher())

    fun start(tick: Long) {
        cycle.start(tick)
    }

    private fun CoroutineScope.start(tick: Long) = launch {
        while (true) {
            val elapsedNanos = measureNanoTime { World.gameLogic() } + excessCycleNanos
            val elapsedMillis = TimeUnit.NANOSECONDS.toMillis(elapsedNanos)
            val isOverdue = elapsedMillis > tick
            val sleepTime = if(isOverdue) {
                val elapsedCycleCount = elapsedMillis / tick
                val nextCycleDelay = (elapsedCycleCount + 1) * tick
                nextCycleDelay - elapsedMillis
            } else {
                tick - elapsedMillis
            }

            if(isOverdue) {
                Logger.error("Game tick took longer than expected (active=${elapsedMillis}ms, idle=${sleepTime}ms). Is the server overloaded?")
            }

            excessCycleNanos = elapsedNanos - TimeUnit.MILLISECONDS.toNanos(elapsedMillis)
            delay(sleepTime)
        }
    }
}