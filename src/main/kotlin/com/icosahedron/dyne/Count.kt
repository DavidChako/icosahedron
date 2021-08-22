package com.icosahedron.dyne

import java.math.BigInteger

data class Count(private val value: BigInteger) {
    init { require(value >= BigInteger.ZERO) }
    constructor(value: Int): this(value.toBigInteger())
    override fun toString() = value.toString()
    operator fun plus(addend: Count) = Count(value + addend.value)
    fun plusOne() = Count(value + BigInteger.ONE)

    fun minusOne(): Count {
        if (value == BigInteger.ZERO) throw IllegalStateException()
        return Count(value - BigInteger.ONE)
    }
}
