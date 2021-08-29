package com.icosahedron.dyne

import mu.KotlinLogging
import java.util.*

data class SpanMonteCarlo(val initialSpan: Span, val runCount: Int, val stepCount: Int, val random: Random = Random()) {
    private val logger = KotlinLogging.logger {}
    private val distanceByTime = Array(stepCount+1) { IntArray(stepCount+1+initialSpan.radius()) }

    fun run() {
        val start = System.currentTimeMillis()
        logger.info { "Started $runCount runs of $stepCount steps with initial span: $span"}

        repeat(runCount) {
            ++distanceByTime[0][span.radius()]

            (1..stepCount).forEach { step ->
                span.step(random);
                ++distanceByTime[step][span.radius()];
            }
        }

        val elapsed = System.currentTimeMillis() - start
        logger.info { "Finished $runCount runs of $stepCount steps in $elapsed millis with final span: $span"}
    }
}