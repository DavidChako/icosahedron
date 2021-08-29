package com.icosahedron.dyne

import mu.KotlinLogging
import java.util.*

data class SpanMonteCarlo(val pole: Pole, val runCount: Int, val stepCount: Int, val random: Random = Random()) {
    private val logger = KotlinLogging.logger {}
    private val radiusDelta = Array(stepCount+1) { IntArray(2*stepCount + 1) }

    fun run() {
        radiusDelta[0][0] = 0

        val start = System.currentTimeMillis()
        logger.info { "Started $runCount runs of $stepCount steps with initial pole: $pole"}

        repeat(runCount) {
            ++distanceByTime[0][span.radius()]

            (1..stepCount).forEach { step ->
                span.step(random);
                ++distanceByTime[step][span.radius()];
            }
        }

        val elapsed = System.currentTimeMillis() - start
        logger.info { "Finished $runCount runs of $stepCount steps in $elapsed millis with final pole: $pole"}
    }
}