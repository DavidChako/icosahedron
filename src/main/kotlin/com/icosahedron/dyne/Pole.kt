package com.icosahedron.dyne

import java.math.BigInteger
import java.util.*

data class Pole(val origin: Event, val endpoint: Event) {
    companion object {
        val TWO: BigInteger = BigInteger.valueOf(2)

        fun pick(bound: BigInteger, random: Random = Random()): BigInteger {
            val candidate = BigInteger(bound.bitLength(), random)
            return if (candidate < bound) candidate else pick(bound, random)
        }
    }

    init {
        require(origin.shell() == endpoint.shell())
        require(origin.frequency() == endpoint.frequency())
    }

    private val ray = Array(4) { n -> endpoint.location[n] - origin.location[n] }

    fun step(random: Random = Random()): Int {
        val bound = origin.frequency() * endpoint.frequency()
        var discriminant = pick(bound, random)

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

        val originRadialEffect = if (ray[originMove]-- > BigInteger.ZERO) -1 else +1
        val endpointRadialEffect = if (ray[endpointMove]++ < BigInteger.ZERO) -1 else +1
        return originRadialEffect + endpointRadialEffect / 2
    }
}
