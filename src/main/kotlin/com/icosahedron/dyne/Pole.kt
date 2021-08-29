package com.icosahedron.dyne

import java.math.BigInteger
import java.util.*

data class Pole(val origin: Event, val endpoint: Event) {
    companion object {
        val TWO = BigInteger.valueOf(2)

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

    fun radius() = ray.sumOf{ it.abs() }.divide(TWO)

    fun step(random: Random = Random()): BigInteger {
        val bound = origin.frequency() * endpoint.frequency()
        var discriminant = pick(bound, random)

        origin.inertia.forEachIndexed { originDirection, originFactor ->
            endpoint.inertia.forEachIndexed { endpointDirection, endpointFactor ->
                val contribution = originFactor * endpointFactor
                if (discriminant < contribution) return step(originDirection, endpointDirection)
                discriminant -= contribution
            }
        }

        throw IllegalStateException()
    }

    fun step(originDirection: Int, endpointDirection: Int): BigInteger {
        origin.location.increment(originDirection)
        endpoint.location.increment(endpointDirection)
        ray[originDirection]--
        ray[endpointDirection]++
        return radius()
    }
}
