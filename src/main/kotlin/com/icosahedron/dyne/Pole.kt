package com.icosahedron.dyne

import kotlin.random.Random

data class Pole(val origin: Event, val endpoint: Event) {
    companion object {
        fun pick(bound: Long): Long = Random.nextLong(0, bound)
    }

    init {
        require(origin.shell() == endpoint.shell())
        require(origin.frequency() == endpoint.frequency())
    }

    private val ray = Array(4) { n -> endpoint.location[n] - origin.location[n] }

    constructor(pole: Pole): this(Event(pole.origin), Event(pole.endpoint))

    fun step(): Int {
        val bound = origin.frequency() * endpoint.frequency()
        var discriminant = Random.nextLong(0, bound)

        origin.inertia.forEachIndexed { originMove, originFactor ->
            endpoint.inertia.forEachIndexed { endpointMove, endpointFactor ->
                val contribution = originFactor * endpointFactor
                if (discriminant < contribution) return step(originMove, endpointMove)
                discriminant -= contribution
            }
        }

        throw IllegalStateException()
    }

    private fun step(originMove: Int, endpointMove: Int): Int {
        origin.location.increment(originMove)
        endpoint.location.increment(endpointMove)

        if (originMove == endpointMove) return 0

        val originRadialEffect = if (ray[originMove]-- > 0) -1 else +1
        val endpointRadialEffect = if (ray[endpointMove]++ < 0) -1 else +1
        return (originRadialEffect + endpointRadialEffect) / 2
    }
}
