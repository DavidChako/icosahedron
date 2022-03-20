package com.icosahedron.common

import java.math.BigInteger

data class Count(val value: BigInteger) {
    constructor(value: Int): this(value.toBigInteger())
    init { require(value >= BigInteger.ZERO) { "Value=$value is negative"} }

    override fun toString() = value.toString()
    operator fun plus(addend: Count) = Count(value + addend.value)

    fun plusOne() = Count(value + BigInteger.ONE)

    fun minusOne(): Count {
        if (value == BigInteger.ZERO) throw IllegalStateException("Unable to subtract from zero")
        return Count(value - BigInteger.ONE)
    }
}
