package com.icosahedron.dyne

import mu.KotlinLogging
import java.util.*

data class PoleMonteCarlo(val pole: Pole, val runCount: Int, val stepCount: Int, val random: Random = Random()) {
    private val logger = KotlinLogging.logger {}
    private val radiusDelta = Array(stepCount + 1) { IntArray(2*stepCount + 1) }

    fun run() {
        val start = System.currentTimeMillis()
        logger.info { "Started $runCount runs of $stepCount steps with initial pole: $pole"}

        repeat(runCount) {
            var offset = stepCount
            ++radiusDelta[0][offset]

            (1..stepCount).forEach { step ->
                offset += pole.step(random)
                ++radiusDelta[step][offset]
            }
        }

        val elapsed = System.currentTimeMillis() - start
        println(radiusDelta[0].joinToString(","))
        logger.info { "Finished $runCount runs of $stepCount steps in $elapsed millis with final pole: $pole"}
        logger.info { "*** Radius Delta Histogram:\n" + radiusDeltaHistogram() }
    }

    private fun radiusDeltaHistogram(): String {
        val header = "T," + (-stepCount..stepCount).joinToString(",")
        val bodyRows = (0..stepCount).map { step -> step.toString() + "," + radiusDelta[step].joinToString(",") }
        return header + "\n" + bodyRows.joinToString("\n")
    }
}